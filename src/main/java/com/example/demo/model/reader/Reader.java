package com.example.demo.model.reader;



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
@Table(name = "READER")
public class Reader implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911645628394574171L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long readerId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	

}
