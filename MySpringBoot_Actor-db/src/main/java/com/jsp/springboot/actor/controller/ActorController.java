package com.jsp.springboot.actor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.actor.model.Actor;
import com.jsp.springboot.actor.service.ActorService;
import com.jsp.springboot.actor.utility.ResponseStructure;
//
//@Controller
//@ResponseBody
@RestController
public class ActorController {
	@Autowired
	private ActorService actorService;
	
//	@RequestMapping(method = RequestMethod.POST, value = "/actors/addActor")
	@PostMapping(value = "/actors/addActor")
	public ResponseEntity<ResponseStructure<Actor>> addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	
//	@RequestMapping(method = RequestMethod.GET , value = "/actors/findByActorId/{actorId}")
	@GetMapping(value = "/actors/findByActorId/{actorId}" )
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(@PathVariable int actorId) {
		return actorService.findByActorId(actorId);
	}
	
//	@RequestMapping(method = RequestMethod.PUT , value = "/actors/updateByActorId/{actorId}")
	@PutMapping(value = "/actors/updateByActorId/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> updateByActorId(@PathVariable int actorId , @RequestBody Actor actor) {
		return actorService.updateByActorId(actorId, actor);
	}
	
//	@RequestMapping(method = RequestMethod.DELETE , value = "/actors/deleteByActorId//{actorId}")
	@DeleteMapping(value = "/actors/deleteByActorId/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> deleteByactorId(@PathVariable int actorId) {
		return actorService.deleteByActorId(actorId);
	}
	
//	@RequestMapping(method = RequestMethod.GET , value = "/actors/findAllActors")
	@GetMapping(value = "/actors/findAllActors")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors(){
		return actorService.findAllActors();
	}
	
	/*
	 * @RequestMapping(value = "/print" , method = RequestMethod.GET) public String
	 * print(@RequestParam String name , @RequestParam String city) { return name +
	 * " belongs to " + city; }
	 * 
	 * @RequestMapping(value = "/calculate" , method = RequestMethod.GET) public int
	 * print(@RequestParam int num1 , @RequestParam int num2) { int sum= num1 +
	 * num2; return sum; }
	 */

}
