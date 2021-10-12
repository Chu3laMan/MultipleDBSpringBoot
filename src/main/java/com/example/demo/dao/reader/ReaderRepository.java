package com.example.demo.dao.reader;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.reader.Reader;


public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
