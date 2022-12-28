package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.TodoAddRequest;
import com.example.demo.dto.TodoSearchRequest;
import com.example.demo.dto.TodoUpdateRequest;
import com.example.demo.entity.Todo;

@Mapper
public interface TodoMapper {
	
	//全表示
	List<Todo> showAll();
	
	//未完了のみ表示
	List<Todo> showIncomplete();
	
	//完了のみ表示
	List<Todo> showComplete();
	
	//条件指定検索
	List<Todo> search(TodoSearchRequest todo);

	//新規TODO追加登録
	void save(TodoAddRequest todoAddRequest);
	
	//TODO IDで検索
	Todo findById(Long todoId);
	
	//更新
	void update(TodoUpdateRequest todoUpdateRequest);
	
	//削除

}
