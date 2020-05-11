package com.ashok;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIs {
	public static void main(String[] args) {
		
		List<Manager> list= new ArrayList<Manager>();
		list.add(new Manager(1, 90000, "Ram"));
		list.add(new Manager(6, 20000, "tom"));
		list.add(new Manager(2, 450000, "shiva"));
		list.add(new Manager(5, 230000, "shakti"));
		list.add(new Manager(3, 120000, "ashok"));
		list.add(new Manager(4, 80000, "Kranti"));
		
		//list.stream().forEach(n -> System.out.println(n));
		
		list= list.stream().sorted().collect(Collectors.toList());
		//list.stream().forEach(n -> System.out.println(n));
		
		list= list.stream().sorted(new Comparator<Manager>() {

			@Override
			public int compare(Manager var1, Manager var2) {
				if(var1.getSalary() < var2.getSalary())
					return -1;
				else
					return 1;
			}
		}).collect(Collectors.toList());
		list.stream().forEach(n -> System.out.println(n));
		
		
	} 
}
class Manager implements Comparable<Manager>{
	private Integer id;
	private Integer salary;
	private String name;
	public Manager(Integer id, Integer salary, String name)
	{
		this.id= id;
		this.salary= salary;
		this.name= name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Manager var1) {
		// TODO Auto-generated method stub
		if(this.id < var1.getId())
			return -1;
		else
			return 1;
	}
}
