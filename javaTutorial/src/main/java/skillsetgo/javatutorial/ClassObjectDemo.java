package skillsetgo.javatutorial;

public class ClassObjectDemo {
	public static void main(String[] args) {
		//Class and Object
		//Class: A class is a group of objects which have 
		//		common properties. 
		//It is a template or blueprint from which objects 
		//are created. It is a logical entity. 
		//It can't be physical.
		
		//Object: An entity that has state and behavior 
		//is known as an object
		//Employee emp1 = new Employee("employee1", 30000);
		//emp1.print();
		
		/*
		 * Employee emp2 = new Employee("employee2", 20000); emp2.print();
		 * emp2.setSalary(50000); emp2.print();
		 */
	}
}

class Employee1 {
	String name;
	int salary;
	
	Employee1(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	
	void setSalary(int salary) {
		this.salary = salary;
	}
	void print() {
		System.out.println(name);
		System.out.println(salary);
	}
}
