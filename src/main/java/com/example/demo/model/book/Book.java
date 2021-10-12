package com.example.demo.model.book;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8667058047447572075L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	@NotNull
	private String author;
	@NotNull
	private String bookName;
	@NotNull
	private String isbn;
	
	

}
