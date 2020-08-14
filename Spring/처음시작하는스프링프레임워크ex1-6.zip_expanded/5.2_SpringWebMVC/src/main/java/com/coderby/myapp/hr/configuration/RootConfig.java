package com.coderby.myapp.hr.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" }) // 패키지를 여러개 쓸 수 있음
@PropertySource("classpath:database/jdbc.properties")
@EnableAspectJAutoProxy
//@EnableScheduling
@EnableTransactionManagement
public class RootConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);
	private static final int TX_METHOD_TIMEOUT = 3;

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		hikariConfig.setJdbcUrl(env.getProperty("jdbc.url"));

		hikariConfig.setUsername(env.getProperty("jdbc.username"));
		hikariConfig.setPassword(env.getProperty("jdbc.password"));

		hikariConfig.setMinimumIdle(5);
		// test Query
		hikariConfig.setConnectionTestQuery("SELECT sysdate FROM dual");
		hikariConfig.setPoolName("springHikariCP");

		hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

		HikariDataSource dataSource = new HikariDataSource(hikariConfig);

		return dataSource;
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
