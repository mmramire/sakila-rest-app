package com.maticode.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@Data
public class FilmViewDTO {
	private int filmID;
	private String title;
	private String description;
	private String category;
	private Long price;
	private int length;
	private String rating;
	private String actors;
}
