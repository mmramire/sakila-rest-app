package com.maticode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.maticode.controller.ActorController;

import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class SakilaRestAppApplicationTests {

	@Autowired
	private ActorController actorController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(actorController).isNotNull();
	}

}
