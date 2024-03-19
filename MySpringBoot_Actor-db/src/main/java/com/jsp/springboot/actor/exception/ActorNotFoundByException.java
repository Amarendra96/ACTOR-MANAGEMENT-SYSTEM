package com.jsp.springboot.actor.exception;

public class ActorNotFoundByException extends RuntimeException {
	private String message;

	public ActorNotFoundByException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
