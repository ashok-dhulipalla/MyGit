package com.park.exception;

public class InvalidTokenException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidTokenException(String message)
	{
		super(message);
	}
	public InvalidTokenException(String message,Throwable e) {
		super(message,e);
	}
}
