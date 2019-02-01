package com.db.exception;

public class Connectionexception extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public Connectionexception(String message)
	{
		super(message);
	}
	public Connectionexception(String message,Throwable t)
	{
		super(message,t);
	}
	public Connectionexception(Throwable t)
	{
		super(t);
	}
}
