package com.liqui.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource(value = { "classpath:application.properties"})
public class MasterDatabaseConfig {

	 @Profile("dev")
	 @Bean(name = "devDataSource")
	 @ConfigurationProperties(prefix = "dev.datasource")
	 public DataSource devDataSource() {
	  return DataSourceBuilder.create().build();
	 }
	
	/*
	 @Bean(name = "devJdbcTemplate") public JdbcTemplate
	 devJdbcTemplate(@Qualifier(value="devDataSource") DataSource devDataSource) {
	  return new JdbcTemplate(devDataSource); }
	 */
	 
	 @Profile("prod")
	 @Bean(name = "prodDataSource")
	 @ConfigurationProperties(prefix = "prod.datasource")
	 public DataSource prodDataSource() {
	  return DataSourceBuilder.create().build();
	 }

	/*
	 * @Bean(name = "prodJdbcTemplate") public JdbcTemplate
	 * prodJdbcTemplate(@Qualifier("prodDataSource") DataSource prodDataSource) {
	 * return new JdbcTemplate(prodDataSource); }
	 */
	 @Profile("uat")
	 @Bean(name = "uatDataSource")
	 @ConfigurationProperties(prefix = "uat.datasource")
	 public DataSource uatDataSource() {
	  return DataSourceBuilder.create().build();
	 }

	/*
	 * @Bean(name = "uatJdbcTemplate") public JdbcTemplate
	 * uatJdbcTemplate(@Qualifier("uatDataSource") DataSource uat) { return new
	 * JdbcTemplate(uat); }
	 */
	 
}