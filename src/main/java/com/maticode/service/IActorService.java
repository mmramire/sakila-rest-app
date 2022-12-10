package com.maticode.service;

import java.util.List;

import com.maticode.model.Actor;

public interface IActorService {

	public List<Actor> getAllActors();
	public Actor saveActor(Actor actor);
}
