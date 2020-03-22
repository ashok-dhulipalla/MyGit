package com.ashok;

public class UpCastingDownCasting {
	public static void main(String[] args) {
		Fruit fruit= new Apple();
		caller(fruit);
		fruit= new Orange();
		caller(fruit);
		
		Apple apple= new Apple();
		Orange orange= new Orange();
		caller(apple);
		caller(orange);
		
		fruit= new Apple();
		caller1((Apple)fruit);
	}
	
	public static void caller1(Apple apple)
	{
		
	}
	
	public static void caller(Fruit fruit)
	{
		if(fruit instanceof Apple)
		{
			Apple apple= (Apple) fruit;
			apple.methodApple();
		}
		else if(fruit instanceof Orange)
		{
			Orange orange= (Orange) fruit;
			orange.methodOrange();
		}
	}
}

class Fruit{
	public Fruit() {
		// TODO Auto-generated constructor stub
	}
	public void methodFruit()
	{
		System.out.println("Method Fruit");
	}
	@Override
	public String toString() {
		return "Fruit Object instance";
	}
}
class Orange extends Fruit
{
	public Orange() {
		// TODO Auto-generated constructor stub
	}
	public void methodOrange()
	{
		System.out.println("Method orange");
	}
	@Override
	public String toString() {
		return "Orange Object instance";
	}
}

class Apple extends Fruit
{
	public Apple() {
		// TODO Auto-generated constructor stub
	}
	public void methodApple()
	{
		System.out.println("Method apple");
	}
	@Override
	public String toString() {
		return "Apple Object instance";
	}
}
