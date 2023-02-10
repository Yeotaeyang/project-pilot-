package com.mc.mvc.todo.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mc.mvc.member.dto.Member;
import com.mc.mvc.member.service.MemberService;
import com.mc.mvc.member.validator.form.SignUpFormValidator;
import com.mc.mvc.todo.dto.Todo;
import com.mc.mvc.todo.dto.deleteTodo;
import com.mc.mvc.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("todo")
public class todoController {
	
	private final MemberService memberService;
	private final SignUpFormValidator signUpFormValidator;
	private final TodoService todoService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/todo-form")
	public void todo() {
		System.out.println("todo-form으로 이동합니다");
	}

	@GetMapping("/login")
	public void Login() {
		System.out.println("login으로 이동합니다.");
	}

	@PostMapping("/login")
	public String login(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		
//		System.out.println(member);
		if(member.getUserId().equals("") | member.getPassword().equals("")) {
			redirectAttr.addFlashAttribute("msg", "아이디나 비밀번호를 입력해주세요.");
			return "redirect:/todo/login";
		} 
		
		Member auth = memberService.authenticateUser(member);

		if (auth == null) {
			redirectAttr.addFlashAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
			System.out.println("auth = null");
			return "redirect:/todo/login";
		}

		session.setAttribute("auth", auth);

		return "redirect:/todo/todo-form";
	}
	
	@PostMapping("/addTodo")
	@ResponseBody
	public String addTodo(@RequestBody Todo todo,HttpSession session,RedirectAttributes redirectAttr) {
		if(session.getAttribute("auth")==null) {
			redirectAttr.addFlashAttribute("msg", "session이 만료되었습니다.");
			System.out.println("auth = null");
			return "redirect:/todo/login";
		}
		Member aa=(Member) session.getAttribute("auth");
		String user = aa.getUserId();
		todo.setUserId(user);
		System.out.println(todo);
		todoService.insertNewTodo(todo);
		System.out.println("Todo를 추가합니다.");
		return "";
	}
	
	
	// 아직 미완
	@PostMapping("/doneTodo")
//	@ResponseBody
	public String dontTodo(Todo todo,HttpSession session) {
		System.out.println(todo);
		Member aa=(Member) session.getAttribute("auth");
		String user = aa.getUserId();
		todo.setUserId(user);
		todoService.deleteTodo(todo);
		return "redirect:/todo/todo-form";
	}
	
	
	
	//@RequestBody -> mail핸들러에 있음/ json로 들어온 데이터는 자바 객체에 매핑하는 어노테이션
	
	@PostMapping("deleteTodo")
	@ResponseBody
	public void deleteTodo(@RequestBody Todo todo,HttpSession session) {
		Member aa=(Member) session.getAttribute("auth");
		String user = aa.getUserId();
		todo.setUserId(user);
//		System.out.println(todo);
		System.out.println("삭제하자");
		todoService.deleteTodo(todo);
		
	}
	

	
	
	
}
