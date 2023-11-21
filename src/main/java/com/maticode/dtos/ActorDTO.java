package com.maticode.dtos;

import lombok.Builder;
import lombok.Data;

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
@Data
public class ActorDTO {
	private Long actorId;
	private String firstName;
	private String lastName;
	private String lastUpdate;
}
