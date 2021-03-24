package com.tekspace.learning.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration()
@ComponentScan(basePackages = "com.tekspace.learning")
@PropertySource(value = {"classpath:application.properties"})
public class DBConfiguration {
	
	/*
	 * jdbc.driverClassName="com.mysql.jdbc.Driver"
jdbc.url="jdbc:mysql://localhost:3306/tekspace_learning"
jdbc.userName="root"
jdbc.password="rootroot"

	 */
	//jdbc templat(source)
	//Datasour
	
	//datasource bean values supply


	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		
		//dri
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.userName"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate=new  JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

}
