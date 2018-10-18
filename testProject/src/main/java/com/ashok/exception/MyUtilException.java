package com.ashok.exception;

public class MyUtilException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MyUtilException(String message)
	{
		super(message);
	}
	public MyUtilException(String message,Throwable e) {
		super(message,e);
	}
}
