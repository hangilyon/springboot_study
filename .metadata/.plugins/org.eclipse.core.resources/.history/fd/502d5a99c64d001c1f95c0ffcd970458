package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.care.root.service.SearchService;

@Controller
public class MovieController {
	@Autowired SearchService service;
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	@GetMapping("/searchMovie")
	public String searchMovie(Model model) {
		model.addAttribute("movie",service.getMovieView());
		return "searchMovie";
	}
}
