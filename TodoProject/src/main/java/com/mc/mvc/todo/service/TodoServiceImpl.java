package com.mc.mvc.todo.service;

import org.springframework.stereotype.Service;

import com.mc.mvc.todo.dto.Todo;
import com.mc.mvc.todo.todoRepository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

	private final TodoRepository todoRepository;

	@Override
	public void insertNewTodo(Todo todo) {
		todoRepository.insertNewTodo(todo);
		
	}

	@Override
	public void deleteTodo(Todo todo) {
		todoRepository.deleteTodo(todo);
		
	}
	
	
}
