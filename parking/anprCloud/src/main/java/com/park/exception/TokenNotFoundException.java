package com.park.exception;

public class TokenNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public TokenNotFoundException(String message)
	{
		super(message);
	}
	public TokenNotFoundException(String message,Throwable e) {
		super(message,e);
	}
}
