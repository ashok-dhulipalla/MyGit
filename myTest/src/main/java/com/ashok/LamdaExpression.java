package com.ashok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LamdaExpression {

	public static void main(String[] args) {
		
//		FuncInterface obj1= (n) -> System.out.println(n*n);
//		FuncInterface obj2= (n) -> System.out.println(n+2);
//		obj1.abstractFun(12);
//		obj2.abstractFun(12);
//		
//		SecFuncInterface obj3= (m,n) -> {m= m+n;System.out.println(m);};
//		obj3.abstractFun(12, 13);
//		fun(n-> System.out.println(n*n));
//		fun(n-> System.out.println(n+n));
//		fun(n-> System.out.println(n-n));
		
		ArrayList<Integer> arr= new ArrayList<Integer>();
		arr.add(5);
		arr.add(34);
		arr.add(54);
		//arr.forEach(n->System.out.println(n+10));
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		map.put("str1", 10);
		map.put("str2", 110);
		map.put("str3", 1110);
		map.put("str4", 11110);
		map.forEach((m,n) -> System.out.println(m+" "+n));
	}
	static void fun(FuncInterface funInterface)
	{
		funInterface.abstractFun(12);
	}
}
//Functional interface
interface FuncInterface 
{ 
	void abstractFun(Integer x); 
		
	default void normalFun() 
	{ 
		System.out.println("Hello"); 
	} 
}
//Functional interface
interface SecFuncInterface 
{ 
	void abstractFun(Integer x,Integer y); 
		
	default void normalFun() 
	{ 
		System.out.println("Hello"); 
	} 
}
