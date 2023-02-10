package com.mc.mvc.calendar.controller;

import com.mc.mvc.calendar.dto.Calendar;
import com.mc.mvc.calendar.service.CalendarService;
import com.mc.mvc.member.dto.Member;
import com.mc.mvc.member.service.MemberService;
import com.mc.mvc.member.validator.form.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("calendar")
public class CalendarController {
	
	private final MemberService memberService;
	private final SignUpFormValidator signUpFormValidator;

	private final CalendarService calendarService;
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
	
	@GetMapping("/calendar")
	public void calendar() {
		System.out.println("calendar으로 이동합니다.");
	}

	@PostMapping("/calendarTodo")
	public String addCalendarTodo(Calendar calendar, HttpSession session, RedirectAttributes redirectAttr) {
		System.out.println(calendar);
		if(session.getAttribute("auth")==null) {
			redirectAttr.addFlashAttribute("msg", "session이 만료되었습니다.");
			System.out.println("auth = null");
			return "redirect:/calendar/calendar";
		}
		Member aa=(Member) session.getAttribute("auth");
		String user = aa.getUserId();
		calendar.setUserId(user);
//      System.out.println(calendar);

		calendarService.insertNewTodo(calendar);
		System.out.println("Todo를 추가합니다.");
		return "redirect:/calendar/calendar";
	}


}
