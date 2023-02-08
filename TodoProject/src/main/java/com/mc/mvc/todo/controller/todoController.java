package com.mc.mvc.todo.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mc.mvc.member.dto.Member;
import com.mc.mvc.member.service.MemberService;
import com.mc.mvc.member.validator.form.SignUpFormValidator;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("todo")
public class todoController {
	
	private final MemberService memberService;
	private final SignUpFormValidator signUpFormValidator;
	
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
		
		System.out.println(member);
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

}
