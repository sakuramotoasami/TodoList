package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Todo implements Serializable{
	private Long todoId;
	
	private String item;
	
	private int completeFlag;
	
	private String priority;
	
	private Long userId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	private Date createDate;
	
	private Date updateDate;
	
	private Date completeDate;
	
	private Date deleteDate;
}
