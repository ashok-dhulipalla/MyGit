package com.ashok.transientDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientDemo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private transient String nickName;
	private TransientDemo demo;
	private Test test;
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public TransientDemo getDemo() {
		return demo;
	}
	public void setDemo(TransientDemo demo) {
		this.demo = demo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "TransientDemo [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName + ", demo="
				+ demo + "]";
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream os= new FileOutputStream(TransientDemo.class.getResource("content.ser").getPath());
		ObjectOutputStream oos= new ObjectOutputStream(os);
		TransientDemo demo = new TransientDemo();
		demo.setFirstName("Ashok");
		demo.setLastName("Dhulipalla");
		demo.setNickName("Ashok Kumar Dhulipalla");
		TransientDemo demo1= new TransientDemo();
		demo1.setFirstName("first Name");
		demo1.setLastName("last Name");
		demo.setDemo(demo1);
		Test test= new Test();
		test.setName("test name");
		demo.setTest(test);
		oos.writeObject(demo);
		oos.flush();
		os.flush();
		demo.setLastName("last Name changed");
		//oos.writeObject(demo);
		
		oos.flush();
		os.flush();
		System.out.println("Done");
		
		FileInputStream is= new FileInputStream(TransientDemo.class.getResource("content.ser").getPath());
		ObjectInputStream ois= new ObjectInputStream(is);
		demo= (TransientDemo)ois.readObject();
		System.out.println(demo);
		//demo= (TransientDemo)ois.readObject();
		//System.out.println(demo);
		is.close();
		ois.close();
		
		
	}
}
class Test implements Serializable
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
