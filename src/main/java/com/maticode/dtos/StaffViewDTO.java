package com.maticode.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@Data
public class StaffViewDTO {
	private int staffID;
	private String name;
	private String address;
	private String zipCode;
	private String phoneNumber;
	private String city;
	private String country;
}
