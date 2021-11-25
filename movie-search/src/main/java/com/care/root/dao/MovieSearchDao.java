package com.care.root.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.care.root.dto.SearchMovieDto;

public interface MovieSearchDao {
	@Results(id="searchMovieDto", value={
			@Result(property = "movieId", column="movie_id"),
			@Result(property = "movieTitle", column="movie_title"),
			@Result(property = "movieDate", column="movie_date"),
			@Result(property = "count", column="count")
	})
	@Select("select * from movie_playing")
	public List<SearchMovieDto> getMovies();

	@ResultMap("searchMovieDto")
	@Select("select * from movie_playing where movie_id = #{movieId}")
	public SearchMovieDto getMovieInfo(String movieId);
	// id를 넘겨주고 잔여 티켓수량을 가져오는 method
	@Select("select count from movie_playing where movie_id=#{movieId}")
	public Integer getCount(Integer movieId);
	@Update("update movie_playing set count = count - #{count} where movie_id= #{movieId}")
	public void subCount(Map map);

}

