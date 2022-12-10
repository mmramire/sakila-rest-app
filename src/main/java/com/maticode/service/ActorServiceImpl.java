package com.maticode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.model.Actor;
import com.maticode.repository.ActorRepository;

import jakarta.transaction.Transactional;

@Service("actorServiceImpl")
@Transactional
public class ActorServiceImpl implements IActorService {

	Logger logger = LoggerFactory.getLogger(ActorServiceImpl.class.getName());

	@Autowired
	private ActorRepository actorRepository;

	/**
	 * Fetch all the columns in ACTOR table.
	 * 
	 * @return List<Actor>
	 */
	@Override
	public List<Actor> getAllActors() {

		List<Actor> actors = new ArrayList<Actor>();

		logger.debug("Searching for all actors in the table.");

		Iterable<Actor> actorsIterator = actorRepository.findAll();

		actors = StreamSupport.stream(actorsIterator.spliterator(), false).collect(Collectors.toList());

		logger.debug("Fetched all device in the table.");

		return actors;

	}

	@Override
	public Actor saveActor(Actor actor) {
		return actorRepository.save(actor);
	}
}
