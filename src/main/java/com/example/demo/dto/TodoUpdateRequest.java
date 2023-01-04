package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TodoUpdateRequest extends TodoAddRequest implements Serializable {
	
	@NotNull
	private Long todoId;
	
	private String completeFlag;
}
