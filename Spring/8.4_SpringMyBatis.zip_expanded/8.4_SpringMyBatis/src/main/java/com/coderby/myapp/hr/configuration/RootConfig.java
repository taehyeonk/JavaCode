package com.coderby.myapp.hr.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = { "com.coderby.myapp" })
@MapperScan(basePackages= {"com.coderby.myapp.hr.dao"})
@PropertySource("classpath:database/jdbc.properties")
@EnableAspectJAutoProxy
@Aspect
@EnableScheduling
@EnableTransactionManagement
public class RootConfig {
	@Autowired
	private Environment env;
	@Autowired
	ApplicationContext applicationContext;

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

	// jdbc template 대신에 사용
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		Properties mappings = new Properties();
		mappings.setProperty("java.lang.RuntimeException", "error/runtime");
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setExceptionMappings(mappings);
		exceptionResolver.setDefaultErrorView("error/default");
		return exceptionResolver;
	}
}
