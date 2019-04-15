package com.properties;

import java.io.IOException;

import com.properties.exception.PropertiesFileException;

public class Test1 
{
	public static void main(String[] args) throws PropertiesFileException {
		
		PropertyFile.loadProperties("props.properties");
		System.out.println(PropertyFile.getProperty("firstName"));
	}
}
