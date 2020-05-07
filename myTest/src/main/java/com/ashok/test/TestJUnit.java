package com.ashok.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJUnit{
	
	@Test
	public void testAdd()
	{
	      String str = "Junit is working fine";
	      assertEquals("Junit is working fine",str);
	}
}
