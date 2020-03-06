package com.ash.SpringFramework;

public class Student {
	private String name;  

	public String getName() {  
		return name;  
	}  

	public void setName(String name) {
		System.out.println("setName method");
		this.name = name;  
	}  

	public void displayInfo(){  
		System.out.println("Hello: "+name);  
	}  
}
