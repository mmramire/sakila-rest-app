package com.maticode.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@Data
public class CustomerViewDTO {

	private int customerID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String city;
	private String country;

}