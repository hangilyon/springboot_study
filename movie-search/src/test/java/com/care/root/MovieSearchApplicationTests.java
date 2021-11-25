package com.care.root;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.care.root.dao.MovieSearchDao;
import com.care.root.dto.SearchMovieDto;

@SpringBootTest
class MovieSearchApplicationTests {
	@Autowired MovieSearchDao dao;
	@Test void contextLoads() {
		Assert.assertNotNull(dao);
		List<SearchMovieDto> list =  dao.getMovies();
		Assert.assertNotSame(list.size(), 0); 
	}
}
