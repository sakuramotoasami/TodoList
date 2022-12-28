package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TodoAddRequest implements Serializable {
	
	@NotEmpty(message="やることを入力してください")
	private String item;
	
	private String priority;
	
	private Long userId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;

}
