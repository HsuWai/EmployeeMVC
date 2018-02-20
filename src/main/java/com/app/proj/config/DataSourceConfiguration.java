package com.app.proj.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author HsuWaiWaiTun
 *
 */
@Configuration
@PropertySource( value= {"classpath:application.properties"})
public class DataSourceConfiguration extends WebMvcConfigurerAdapter{
	
	@Value("${spring.datasource.driverClassName}")
	private String driverName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

	 @Bean(name = "dataSource")
	 public DataSource dataSource() {
	     DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	         dataSourceBuilder.url(url);
	         dataSourceBuilder.username(username);
	         dataSourceBuilder.password(password);
	         dataSourceBuilder.driverClassName(driverName);
	         return dataSourceBuilder.build();   
	 }
	 
}
