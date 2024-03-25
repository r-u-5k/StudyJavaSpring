package com.itwill.datasource.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

/*
 * @Configuration
 *   - Spring Boot가 초기화되면서 설정 파일의 모든 
 *     메서드를 호출한 반환 객체를 빈으로 등록함
 */
@Configuration
public class DataSourceConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.dbcp2")
	public DataSource dataSource1() {
		System.out.println("--> DataSourceConfig.dataSource()");
		return DataSourceBuilder.create().type(BasicDataSource.class).build();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource dataSource2() {
		System.out.println("--> DataSourceConfig.dataSource()");
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
}
