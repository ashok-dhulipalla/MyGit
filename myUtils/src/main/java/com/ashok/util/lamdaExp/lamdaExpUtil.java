package com.ashok.util.lamdaExp;

import java.util.List;
import java.util.stream.Stream;

public class lamdaExpUtil {

	/**
	 * 
	 * @param list Prints all values in the list which satisfies below condition
	 * @param condition
	 * 1 for Equal, Prints values where value == conditionValue<br>
	 * 2 for notEqual<br>
	 * 3 for lessThan<br>
	 * 4 for greaterThan<br>
	 * 5 for lessThanOrEqual<br>
	 * 6 for greaterThanOrEqual
	 * @param conditionValue
	 */
	public static <T> void printList(List<T> list,Integer condition, T conditionValue)
	{
		Stream<T> stream = list.stream();
		Stream<T> filter= null;
		System.out.println("---- Printing values from the list ----");
		filter= getFilteredStream(stream, condition, conditionValue);
		if(filter != null)
		{
			filter.forEach(e -> System.out.println(e));			
		}
		else
		{
			stream.forEach(e -> System.out.println(e));			
		}
	}
	
	/**
	 * 
	 * @param list Prints all values in the list
	 */
	public static <T> void printList(List<T> list)
	{
		printList(list, null, null);
	}
	
	/**
	 * 
	 * @param Add all values in the list which satisfies below condition
	 * @param condition
	 * 1 for Equal, Prints values where value == conditionValue<br>
	 * 2 for notEqual<br>
	 * 3 for lessThan<br>
	 * 4 for greaterThan<br>
	 * 5 for lessThanOrEqual<br>
	 * 6 for greaterThanOrEqual
	 * @param conditionValue
	 * @return sum Sum of values
	 */
	public static Integer addValuesInList(List<Integer> list,Integer condition, Integer conditionValue)
	{
		Stream<Integer> stream = list.stream();
		Stream<Integer> filter= null;
		System.out.println("---- Adding values from the list ----");
		filter= getFilteredStream(stream, condition, conditionValue);
		if(filter != null)
		{
			return filter.mapToInt(e-> e.intValue()).sum();		
		}
		else
		{
			return stream.mapToInt(e-> e.intValue()).sum();			
		}
	}
	
	/**
	 * 
	 * @param list Add all values in the list
	 * @return sum Sum of values in the list
	 */
	public static Integer addValuesInList(List<Integer> list)
	{
		return addValuesInList(list, null, null);
	}

	/**
	 * 
	 * @param stream
	 * @param condition
	 * @param conditionValue
	 * @return stream Filtered based on condition
	 */
	private static <T> Stream<T> getFilteredStream(Stream<T> stream, Integer condition, T conditionValue)
	{
		StringBuilder msg= new StringBuilder();
		if(condition != null && conditionValue != null)
		{
			msg.append("---- With Condition ");
			if(condition == 1) {
				msg.append("== "+conditionValue.toString());
				stream= stream.filter(e-> isEqual(e,conditionValue));				
			}
			if(condition == 2){
				msg.append("!= "+conditionValue.toString());
				stream= stream.filter(e-> !isEqual(e,conditionValue));
			}
			if(condition == 3) {
				msg.append("< "+conditionValue.toString());
				stream= stream.filter(e-> isLessThan(e,conditionValue));
			}
			if(condition == 4) {
				msg.append("> "+conditionValue.toString());
				stream= stream.filter(e-> isGreaterThan(e,conditionValue));
			}
			if(condition == 5) {
				msg.append("<= "+conditionValue.toString());
				stream= stream.filter(e-> isLessThan(e,conditionValue) || isEqual(e, conditionValue));
			}
			if(condition == 6) {
				msg.append(">= "+conditionValue.toString());
				stream= stream.filter(e-> isGreaterThan(e,conditionValue) || isEqual(e, conditionValue));
			}
			System.out.println(msg+" ----");
		}
		return stream;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isEqual(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return obj1 == obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) == 0;
		}
		return false;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isLessThan(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return (Integer)obj1 < (Integer)obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) < 0;
		}
		return false;
	}
	/**
	 * 
	 * @param obj1 Compares obj1 with obj2
	 * @param obj2
	 * @return boolean
	 */
	public static boolean isGreaterThan(Object obj1, Object obj2)
	{
		if(obj2 instanceof Integer)
		{
			return (Integer)obj1 > (Integer)obj2;
		}
		else if(obj2 instanceof String)
		{
			return ((String)obj1).compareToIgnoreCase((String)obj2) > 0;
		}
		return false;
	}
	
}
