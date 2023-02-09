package com.mc.mvc.todo.todoRepository;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mc.mvc.todo.dto.Todo;

@Repository
public interface TodoRepository {

	
	@Insert("insert into todo(user_Id,todo) values(#{userId},#{todo})")
	void insertNewTodo(Todo todo);
	
	

}
