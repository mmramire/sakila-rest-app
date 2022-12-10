package com.maticode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maticode.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

}
