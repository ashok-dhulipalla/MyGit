package com.properties;

import java.io.IOException;

public class Test1 
{
	public static void main(String[] args) throws IOException {
		
		PropertyFile.loadProperties("props.properties");
		System.out.println(PropertyFile.getProperty("firstName"));
	}
}
