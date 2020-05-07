package com.ashok;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.batik.dom.util.HashTable;

public class ImmutableClass {

	public static void main(String[] args) {
//		//Make all fields private so that direct access is not allowed.
//		//Don’t provide setter methods for variables
//		//Initialize all the fields via a constructor performing deep copy.
//		//Make all mutable fields final so that it’s value can be assigned only once.
//		//Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference
//		//Declare the class as final so it can’t be extended.
//		Address address= new Address("Bangalore","Karanataka");
//		Employee employee= new Employee(23, "Ram", address);
//		System.out.println(employee);
//		
//		address= employee.getAddress();
//		address.setCity("Hederabad");
//		
//		System.out.println(employee);
		
		
		Address add1= null;
//		Map<Address,Integer> mapAdd= new HashMap<Address, Integer>();
//		
		add1= new Address("Bangalore", "Karnataka");
//		
//		mapAdd.put(add1, 11);
//		add1.setCity("Hyderabad");
//		add1.setCity("Bangalore");
//		
//		System.out.println(mapAdd.get(add1));
		
//		Map<Employee,Integer> mapEmp= new HashMap<Employee, Integer>();
//		Employee emp= new Employee(23, "ram", add1);
//		
//		mapEmp.put(emp,23);
//		System.out.println(mapEmp.get(emp));
		HashSet<String> set1= new HashSet<String>();
		boolean b1= set1.add("java");
		boolean b2= set1.add("C");
		boolean b3= set1.add("java");
		System.out.format("%b %b %b",b1,b2,b3);
		
		
		
	}
}

final class Employee{
	private int age;
	private String name;
	private final Address address;
	public Employee(int age, String name, Address address) {
		super();
		this.age = age;
		this.name = name;
		this.address = new Address(address.getCity(), address.getState());
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public Address getAddress() {
		return new Address(this.address.getCity(), this.address.getState());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", address=" + address + "]";
	}
}

class Address{
	String city;
	String state;
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		System.out.println("hashCode: "+result);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
}