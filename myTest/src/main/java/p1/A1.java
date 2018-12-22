package p1;

public class A1 {

	public static void main(String[] args) {
		A a= new A();
		
		a.defaultMethod();
		a.protectedMethod();
		//not allowed
		//a.privateMethod();
		
		a.publicMethod();
	}
}
