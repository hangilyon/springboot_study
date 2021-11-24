package com.care.root.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UrlDto extends RepresentationModel<UrlDto>{
	private String title;
	private String url;
	public UrlDto(String title, String url) {
		this.title=title; this.url=url;
	}
}
