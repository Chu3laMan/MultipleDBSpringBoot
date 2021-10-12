package com.example.demo.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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

import com.example.demo.model.book.Book;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.dao.book", entityManagerFactoryRef="bookEntityManagerFactory", transactionManagerRef= "bookTransactionManager")
public class BookDataSourceConfiguration {
	
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.book")
	public DataSourceProperties bookDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.book.configuration")
	public DataSource bookDataSource() {
		return bookDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Bean(name = "bookEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(bookDataSource()).packages(Book.class).build();
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager bookTransactionManager(final @Qualifier("bookEntityManagerFactory") LocalContainerEntityManagerFactoryBean bookEntityManagerFactory) {
		return new JpaTransactionManager(bookEntityManagerFactory.getObject());
	}
	

}
