package com.liqui.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlManagerFactory",
        basePackages = {"com.mds"},
        transactionManagerRef = "mysqlTransactionManager"
)
@PropertySource("classpath:application.properties")
public class MasterDatabaseConfig {
	
	 @Bean(name = "mysqlDataSource")
	 @ConfigurationProperties(prefix = "mysql.datasource")
	 public DataSource dataSource() {
	  return DataSourceBuilder.create().build();
	 }

	 @Bean(name = "mysqlJdbcTemplate")
	 public JdbcTemplate MysqlJdbcTemplate(@Qualifier("mysqlDataSource") DataSource mysql) {
	  return new JdbcTemplate(mysql);
	 }
	 
	
}