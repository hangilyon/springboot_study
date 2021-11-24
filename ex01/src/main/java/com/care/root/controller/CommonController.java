package com.care.root.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	@Autowired HttpSession session;

	@GetMapping("/")
	public String index(Model model) {
		session.setAttribute("user", "session value");
		model.addAttribute("user","model value");
		return "index";
	}
	@GetMapping("test")
	public String test() {
		return "test";
	}
	@RequestMapping("object")
	public String object(Model model) {
		TestDTO sdto = new TestDTO();
		sdto.setName("s 홍길동"); sdto.setAddr("s 산골짜기");
		session.setAttribute("user", sdto);
		TestDTO mdto = new TestDTO();
		mdto.setName("m 홍길동"); mdto.setAddr("m 산골짜기");
		model.addAttribute("user",mdto);

		String msg = "<script>alert('안녕');</script>";
		msg += "<h1>안녕하세요</h1>";
		model.addAttribute("msg",msg);
		return "object";
	}
	@RequestMapping("operator/{num}")
	public ModelAndView operator(@PathVariable int num, ModelAndView mav) {
		// 주소 operator 로 넘어가겠다, return 값
		mav.setViewName("operator");
		List<String> arr = new ArrayList<String>();
		arr.add("홍길동"); arr.add("김개똥"); arr.add("고길동");
		mav.addObject("arr",arr); mav.addObject("num",num);
		mav.addObject("name","김말이");
		return mav;
	}

}
