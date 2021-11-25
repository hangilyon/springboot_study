package com.care.root.dto;
import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchMovieDto extends RepresentationModel<SearchMovieDto>{
	private String movieId;
	private String movieTitle;
	private String movieDate;
	private int count;
}
