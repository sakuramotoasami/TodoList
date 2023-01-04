package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.TodoAddRequest;
import com.example.demo.dto.TodoSearchRequest;
import com.example.demo.dto.TodoUpdateRequest;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping(value="/todo/list")
	public String displayList(Model model) {
//		List<Todo> list = todoService.showAll();
		List<Todo> todoList = todoService.showIncomplete();
//		List<Todo> completelist = todoService.showComplete();
//		model.addAttribute("todos", list);
		model.addAttribute("todolist", todoList);
//		model.addAttribute("completetodos", completelist);
		model.addAttribute("todoSearchRequest", new TodoSearchRequest());
		return "todo/search";
	}
	
	//新規登録画面表示
	@GetMapping(value="/todo/add")
	public String displayAdd(Model model) {
		model.addAttribute("todoAddRequest", new TodoAddRequest());
		return "todo/add";
	}
	
	
	//条件指定検索
	@RequestMapping(value="/todo/search", method = RequestMethod.POST)
	public String search(@ModelAttribute TodoSearchRequest todoSearchRequest, Model model) {
		List<Todo> todoList = todoService.search(todoSearchRequest);
		model.addAttribute("todolist", todoList);
		return "todo/search";
		
	}
	
	//新規登録画面
	@RequestMapping(value="/todo/create", method= RequestMethod.POST)
	public String create(@Validated @ModelAttribute TodoAddRequest todoAddRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error: result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "todo/add";
		}
		todoService.save(todoAddRequest);
		return "redirect:/todo/list";
	}
	
	//編集画面
	@GetMapping("/todo/{todoId}/edit")
	public String displayEdit(@PathVariable Long todoId, Model model) {
		Todo todo = todoService.findById(todoId);
		TodoUpdateRequest todoUpdateRequest = new TodoUpdateRequest();
		todoUpdateRequest.setTodoId(todo.getTodoId());
		todoUpdateRequest.setItem(todo.getItem());
		todoUpdateRequest.setPriority(todo.getPriority());
		todoUpdateRequest.setUserId(todo.getUserId());
		todoUpdateRequest.setDeadline(todo.getDeadline());
		todoUpdateRequest.setCompleteFlag(todo.getCompleteFlag());
		model.addAttribute("todoUpdateRequest", todoUpdateRequest);
		return "todo/edit";
	}
	
	//更新
	@RequestMapping(value="/todo/update", method=RequestMethod.POST)
	public String update(@Validated @ModelAttribute TodoUpdateRequest todoUpdateRequest, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error: result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "todo/edit";
		}
		todoService.update(todoUpdateRequest);
		return "redirect:/todo/list";
	}
	
	//削除
	@GetMapping("/todo/{todoId}/delete") 
	public String delete(@PathVariable Long todoId, Model model) {
		todoService.delete(todoId);
		return "redirect:/todo/list";		
	}
	
	//完了にする
	@GetMapping("/todo/{todoId}/changeToComplete") 
	public String changeToComplete(@PathVariable Long todoId, Model model) {
		todoService.changeToComplete(todoId);
		return "redirect:/todo/list";		
	}
	

}
