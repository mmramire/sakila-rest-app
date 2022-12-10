package com.maticode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maticode.model.Actor;
import com.maticode.repository.ActorRepository;

@Controller
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	private ActorRepository actorRepository;

	@GetMapping(value = "/all")
	public @ResponseBody List<Actor> getAllActors() {
		return (List<Actor>) actorRepository.findAll();
	}
}
