package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoAddRequest;
import com.example.demo.dto.TodoSearchRequest;
import com.example.demo.dto.TodoUpdateRequest;
import com.example.demo.entity.Todo;
import com.example.demo.mapper.TodoMapper;

@Service
public class TodoService {
	
	
	@Autowired
	private TodoMapper todoMapper;
	
	//全表示 mapperのメソッドを返す
	public List<Todo> showAll() {
		return todoMapper.showAll();
	}
	
	//未完了のみ表示 mapperのメソッドを返す
	public List<Todo> showIncomplete() {
		return todoMapper.showIncomplete();
	}
	
	//完了のみ表示 mapperのメソッドを返す
	public List<Todo> showComplete() {
		return todoMapper.showComplete();
	}
	
	//条件指定検索
	public List<Todo> search(TodoSearchRequest todoSearchRequest) {
		return todoMapper.search(todoSearchRequest);
	}
	
	//新規TODO追加 mapperのメソッドを返す
	public void save(TodoAddRequest todoAddRequest) {
		todoMapper.save(todoAddRequest);
	}
	
	//TODO IDで検索
	public Todo findById(Long todoId) {
		return todoMapper.findById(todoId);
	}
	
	//更新
	public void update(TodoUpdateRequest todoUpdateRequest) {
		todoMapper.update(todoUpdateRequest);
	}

}
