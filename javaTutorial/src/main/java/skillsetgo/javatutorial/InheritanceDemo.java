package skillsetgo.javatutorial;

class Person {
	String name;
	int age;
	Person(String name, int age) {
		System.out.println("person constructor");
		this.name = name;
		this.age = age;
	}
	void printDetails() {
		System.out.println("person printdetails");
		System.out.println(name);
		System.out.println(age);
	}
}
class Employee extends Person{
	int salary;
	Employee(String name, int age, int salary) {
		super(name, age);
		System.out.println("employee constructor");
		this.salary = salary;
	}
	void printDetails() {
		super.printDetails();
		System.out.println("employee printdetails");
		System.out.println(salary);
	}
}
public class InheritanceDemo {
	public static void main(String[] args) {
		Employee emp = new Employee("nameDemo",23,30000);
		emp.printDetails();
		//What is Inheritance.
		//-----Mechanism in which one object acquires 
		//all the properties and behaviors of a parent object.
		
		//represents the IS-A relationship 
		//which is also known as a parent-child relationship.
		
		//uses: reusing code and method overriding.
	}
}
