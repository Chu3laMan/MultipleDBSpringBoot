package com.example.demo.dao.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.book.Book;



public interface BookRepository extends JpaRepository<Book, Long> {

}
