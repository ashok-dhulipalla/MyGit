package com.ashok.util.exception;

public class PropertiesFileException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public PropertiesFileException(String message)
	{
		super(message);
	}
	public PropertiesFileException(String message,Throwable e) {
		super(message,e);
	}
}
