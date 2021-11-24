package com.care.root.service;

import java.util.ArrayList;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.care.root.dto.SearchMovieDto;
import com.care.root.movieURL.movieURL;

@Service
public class SearchService implements movieURL{
	RestTemplate movieSearch = new RestTemplate();

	public ArrayList<SearchMovieDto> getMovieView() {
		String test = movieSearch.getForObject(
				movieViewUrl+"/getMovies", String.class);
		System.out.println("movieSearch 연결 결과 : "+test);
		
		ArrayList<SearchMovieDto> list = new ArrayList<SearchMovieDto>();
		// 영화를 누르면 상세보기로 이동을 해야해서 만듦
		String movieURL = "http://localhost:10000/search/movieinfo/";
		for(int i=1 ; i < 6 ; i++) {
			SearchMovieDto dto = new SearchMovieDto();
			dto.setMovieId(i+"");
			dto.setMovieTitle("화성을 지켜라"+i);
			dto.setMovieDate("2200-05-1"+i);
			Link link = Link.of(movieURL+i);
			dto.add(link.withRel(dto.getMovieTitle()));//경로이름
			list.add(dto);
		}
		return list;
	}
}
