package com.ashok;

public class OverridingOverLoading {

	public static void main(String[] args) {
		//Overloading - same method name but different parameters.
		//Overriding - same method name with same parameters in the parent class and the child class.
	
		Parent parent= new Parent();
		parent.method1(5);
		parent.method1("test");
		
		//parent.method1(null);
		parent= new Child();
		parent.method2(6);
	}
}

class Parent
{
	//overload
	public void method1(Integer i)
	{
		System.out.println("method with Integer param");
	}
	//overload
	public String method1(String i)
	{
		System.out.println("method with String param");
		return "test";
	}
	//override
	public void method2(Integer i)
	{
		System.out.println("Parent method");
	}
}

class Child extends Parent
{
	//override
	public void method2(Integer i)
	{
		System.out.println("Child method");
	}
}
