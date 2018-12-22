package p1;

public class A {
	void defaultMethod()
	{
	}
	protected void protectedMethod()
	{
	}
	private void privateMethod()
	{
	}
	public void publicMethod()
	{
	}
	public static void main(String[] args) {
		A a= new A();
		a.defaultMethod();
		a.protectedMethod();
		a.privateMethod();
		a.publicMethod();
	}
}
