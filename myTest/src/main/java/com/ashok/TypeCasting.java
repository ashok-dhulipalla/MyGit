package com.ashok;

public class TypeCasting {

	public static void main(String[] args) {
		/*
		 * Java Type Casting
			Type casting is when you assign a value of one primitive data type to another type.
			
			In Java, there are two types of casting:
			
			Widening Casting (automatically) - converting a smaller type to a larger type size
			byte -> short -> char -> int -> long -> float -> double
			
			Narrowing Casting (manually) - converting a larger type to a smaller size type
			double -> float -> long -> int -> char -> short -> byte
		 */
		int myInt = 99999;
		float myFloat= myInt;
		System.out.println("float "+myFloat);
		
		double myDouble= myInt;
		System.out.println("double "+myDouble);
		
		char mychar= 'a';
		myInt= mychar;
		System.out.println("myInt "+myInt);
		
		byte mybyte= 'b';
		myInt= mybyte;
		System.out.println("myInt "+myInt);
		
		////////////////////////////////////////////////
		myDouble= 1234.567;
		myInt= (int) myDouble;
		System.out.println("myInt "+myInt);
		
		myInt= 98;
		mychar= (char) myInt;
		System.out.println("myChar "+mychar);
		
		
	}
}
