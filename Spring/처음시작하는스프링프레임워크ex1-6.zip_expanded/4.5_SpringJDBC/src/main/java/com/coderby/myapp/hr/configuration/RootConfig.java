package com.coderby.myapp.hr.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" })
@PropertySource("classpath:database/jdbc.properties")
@EnableAspectJAutoProxy
@Aspect
@EnableTransactionManagement
public class RootConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);
	private static final int TX_METHOD_TIMEOUT = 3;

	@Autowired
	private Environment env;

	@Bean
	static public StandardPBEStringEncryptor stringEncryptor() {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		EnvironmentPBEConfig config = new EnvironmentPBEConfig();
		config.setAlgorithm("PBEWithMD5AndDES");
		config.setPasswordEnvName("APP_ENCRYPTION_PASSWORD");
		encryptor.setConfig(config);
		encryptor.setPassword("rktwlsrud");
		return encryptor;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		basicDataSource.setUrl(stringEncryptor().decrypt(env.getProperty("jdbc.url")));
		basicDataSource.setUsername(stringEncryptor().decrypt(env.getProperty("jdbc.username")));
		basicDataSource.setPassword(stringEncryptor().decrypt(env.getProperty("jdbc.password")));
		return basicDataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public TransactionInterceptor txAdvice() {
		TransactionInterceptor txAdvice = new TransactionInterceptor();
		Properties txAttributes = new Properties();
		List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
		rollbackRules.add(new RollbackRuleAttribute(Exception.class));

		/** If need to add additionall exceptio, add here **/
		DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(
				TransactionDefinition.PROPAGATION_REQUIRED);
		readOnlyAttribute.setReadOnly(true);
		readOnlyAttribute.setTimeout(TX_METHOD_TIMEOUT);
		RuleBasedTransactionAttribute writeAttribute = new RuleBasedTransactionAttribute(
				TransactionDefinition.PROPAGATION_REQUIRED, rollbackRules);
		writeAttribute.setTimeout(TX_METHOD_TIMEOUT);
		String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
		String writeTransactionAttributesDefinition = writeAttribute.toString();
		LOGGER.info("Read Only Attributes :: {}", readOnlyTransactionAttributesDefinition);
		LOGGER.info("Write Attributes :: {}", writeTransactionAttributesDefinition);

		// read-only
		txAttributes.setProperty("retrieve*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("select*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("get*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("list*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("search*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("find*", readOnlyTransactionAttributesDefinition);
		txAttributes.setProperty("count*", readOnlyTransactionAttributesDefinition);

		// write rollback-rule
		txAttributes.setProperty("*", writeTransactionAttributesDefinition);
		txAdvice.setTransactionAttributes(txAttributes);
		txAdvice.setTransactionManager(txManager());
		return txAdvice;
	}

	@Bean
	public Advisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//		pointcut.setExpression("(execution(* *..*.service..*.*(..)) || execution(* *..*.services..*.*(..)))");
		pointcut.setExpression("execution(* com.coderby.myapp..*Service.deleteEmp(..))");
		pointcut.setExpression("execution(* com.coderby.myapp.hr.service..*.*(..))");
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
}
