package com.jsp.springboot.actor.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.utility.ResponseStructure;

public interface ActorService {
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor);
	
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId , Actor actor);
	
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors();

}
