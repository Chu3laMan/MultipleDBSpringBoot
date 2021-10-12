package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.book.Book;
import com.example.demo.model.reader.Reader;

@SpringBootApplication
public class MultipleDBsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDBsApplication.class, args);
	}
	
	

}
