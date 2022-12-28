package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TodoSearchRequest implements Serializable {
	
	private String item;
	
	private String userId;


}
