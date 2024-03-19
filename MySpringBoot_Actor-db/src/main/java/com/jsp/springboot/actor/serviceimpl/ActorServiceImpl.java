package com.jsp.springboot.actor.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actor.exception.ActorNotFoundByException;
import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.repository.ActorRepository;
import com.jsp.springboot.actor.service.ActorService;
import com.jsp.springboot.actor.utility.ResponseStructure;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository actorRepository;
	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) {
		Actor actor2 = actorRepository.save(actor);
		
		ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actors Data Created Successfully!!");
		responseStructure.setData(actor2);
		
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure, HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);

		if(optional.isPresent()) {
			Actor actor = optional.get();
			ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actors have been founded ById Successfully!!!");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure , HttpStatus.FOUND);
		}
		else {
			throw new ActorNotFoundByException("Actor Not Found");
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(int actorId, Actor updatedActor) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		
		if(optional.isPresent()) {
			Actor existingActor = optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actors data updated Successfully!!");
			responseStructure.setData(updatedActor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure , HttpStatus.OK);
		}
		else {
			return null;
		}
		
		
	}
	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId) {
		Optional<Actor> optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor = optional.get();
			actorRepository.deleteById(actorId);
			ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor data deleted Successfully!!");
			responseStructure.setData(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure , HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors() {
		List<Actor> actors = actorRepository.findAll();
		
		if(actors.isEmpty()) {
			return null;
		}else {
			ResponseStructure<List<Actor>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Showed all the actors details");
			responseStructure.setData(actors);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure , HttpStatus.FOUND);
		}
	}

}
