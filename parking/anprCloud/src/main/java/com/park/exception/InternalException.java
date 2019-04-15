package com.park.exception;

public class InternalException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InternalException(String message)
	{
		super(message);
	}
	public InternalException(String message,Throwable e) {
		super(message,e);
	}
}
