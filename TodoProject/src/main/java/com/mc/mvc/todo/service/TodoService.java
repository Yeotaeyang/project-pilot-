package com.mc.mvc.todo.service;

import com.mc.mvc.todo.dto.Todo;

public interface TodoService {

    void insertNewTodo(Todo todo);

    void deleteTodo(Todo todo);

}