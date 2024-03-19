package com.jsp.springboot.actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.actor.model.Actor;

@Repository
public interface ActorRepository  extends JpaRepository<Actor, Integer>{
	

}
