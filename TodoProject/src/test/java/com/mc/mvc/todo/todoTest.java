package com.mc.mvc.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mc.mvc.todo.dto.Todo;
import com.mc.mvc.todo.todoRepository.TodoRepository;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class todoTest {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Test
	public void testAddTodo() {
		Todo todo = new Todo();
		todo.setUserId("testAddTodo");
		todo.setTodo("test");
		todoRepository.insertNewTodo(todo);
	}

}
