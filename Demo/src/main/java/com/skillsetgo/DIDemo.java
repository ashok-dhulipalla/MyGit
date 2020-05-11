package com.skillsetgo;

public class DIDemo {

	public static void main(String[] args) {
		
		Engine engine= new PetrolEngine();
		
		Car car= new Car(engine);
		car.start();
		
		Engine engine1= new DieselEngine();
		Car car1= new Car(engine1);
		car1.start();
	}
}
