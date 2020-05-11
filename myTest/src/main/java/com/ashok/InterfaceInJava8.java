package com.ashok;

public class InterfaceInJava8 {

	public static void main(String[] args) {
		//default methods and static methods
		Example2 ex2= new Example2();
		ex2.newMethod("str");
		MyInterface.anotherNewMethod("str");
	}
}

interface MyInterface{
	
	void existingMethod(String str); 
	default void newMethod(String str) {
		
	}; 
	static void anotherNewMethod(String str) {
		
	};
	
}
interface NewInterface{
	
	void existingMethod(String str); 
	default void newMethod(String str) {
		
	}; 
	
}
class Example1 implements MyInterface{

	@Override
	public void existingMethod(String str) {
		// TODO Auto-generated method stub
		System.out.println("existing method");
	}
	@Override
	public void newMethod(String str) {
		System.out.println("new method");
	};
}
class Example2 implements MyInterface, NewInterface{

	@Override
	public void existingMethod(String str) {
		// TODO Auto-generated method stub
		System.out.println("existing method");
	}
	@Override
	public void newMethod(String str) {
		System.out.println("new method Example2");
	};
	
}