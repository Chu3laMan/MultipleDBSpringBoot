package com.example.demo.configuration;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.model.reader.Reader;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableJpaRepositories(basePackages ="com.example.demo.dao.reader", entityManagerFactoryRef ="readerEntityManagerFactory", transactionManagerRef="readerTransactionManager")
public class ReaderDataSourceConfiguration {
	
	@Bean
	@ConfigurationProperties("app.datasource.reader")
	public DataSourceProperties readerDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("app.datasource.reader.configuration")
	public DataSource readerDataSource() {
		return readerDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Bean(name = "readerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean readerEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(readerDataSource()).packages(Reader.class).build();
	}
	
	@Bean
	public PlatformTransactionManager readerTransactionManager(final @Qualifier("readerEntityManagerFactory") LocalContainerEntityManagerFactoryBean readerEntityManagerFactory) {
		return new JpaTransactionManager(readerEntityManagerFactory.getObject());
	}

}
