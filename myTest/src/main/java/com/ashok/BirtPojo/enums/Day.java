package com.ashok.BirtPojo.enums;

import java.util.HashMap;
import java.util.Map;

public enum Day {
	MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);
	
	private int day;
	static Map<Integer,Day> map;
	
	Day()
	{
		
	}
	
	Day(int day)
	{
		this.day= day;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	static {
		map= new HashMap<>();
		for(Day day: Day.values())
			map.put(day.day, day);
	}
	public static Day getDay(int day)
	{
		return map.get(day);
	}
	
}
class test{
	public static void main(String[] args) {
		System.out.println(Day.SUNDAY.getDay());
		System.out.println(Day.getDay(2));
	}
}
