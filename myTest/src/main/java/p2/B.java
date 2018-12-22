package p2;

import p1.A;

public class B{
	public static void main(String[] args) {
		A a= new A();
		
		//not allowed
		//a.defaultMethod();
		//a.protectedMethod();
		//a.privateMethod();
		
		a.publicMethod();
	}
}
class C extends A{
	public static void main(String[] args) {
		C c= new C();
		
		//not allowed
		//c.defaultMethod();
		
		c.protectedMethod();
		
		//not allowed
		//c.privateMethod();
		
		c.publicMethod();
	}
}
