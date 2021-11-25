package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.care.root.dto.MovieBookDto;
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
	@GetMapping("bookview/{movieId}/{movieTitle}/{movieDate}")
	public String bookView(@PathVariable String movieId,
			@PathVariable String movieTitle,
			@PathVariable String movieDate, Model model) {
		model.addAttribute("movieId",movieId);
		model.addAttribute("movieTitle",movieTitle);
		model.addAttribute("movieDate",movieDate);
		return "bookView";
	}
	@PostMapping("booking")
	public String booking(MovieBookDto dto, Model model) {
		String message = service.booking(dto);
		model.addAttribute("msg",message);
		model.addAttribute("book",dto);
		return "booking";
	}
}
