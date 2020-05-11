package com.ashok;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {
	    System.out.println("StringTokenizer Constructor 1 - ");
	    StringTokenizer st1 =
	        new StringTokenizer("Hello Readers, Welcome to DataFlair", " ");
	    while (st1.hasMoreTokens())
	      System.out.println(st1.nextToken());
	    System.out.println("StringTokenizer Constructor 2 - ");
	    StringTokenizer st2 =
	        new StringTokenizer("JAVA : Code : String", " :");
	    while (st2.hasMoreTokens())
	      System.out.println(st2.nextToken());
	    System.out.println("StringTokenizer Constructor 3 - ");
	    StringTokenizer st3 =
	        new StringTokenizer("JAVA Code String", " : ",  true);
	    while (st3.hasMoreTokens())
	      System.out.println(st3.nextToken());
	}
}
