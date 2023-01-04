package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoSearchRequest implements Serializable {
	
	private String item;
	
	private String userId;
	
	private String priority;
	
	private String completeFlag;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;


}
