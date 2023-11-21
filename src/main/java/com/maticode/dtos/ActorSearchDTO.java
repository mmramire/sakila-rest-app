package com.maticode.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorSearchDTO {

	@Nullable
	private String firstName;

	@Nullable
	private String lastName;
}
