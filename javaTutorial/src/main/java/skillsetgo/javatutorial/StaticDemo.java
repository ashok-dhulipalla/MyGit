package skillsetgo.javatutorial;
class JavaStaticVar {
	static private String name = "name";
	String name2 = "name2";
	
	public static void print() {
		System.out.println(name);
		name+= "name";
	}
}
public class StaticDemo {
	public static void main(String[] args) {
		JavaStaticVar obj1 = new JavaStaticVar();
		JavaStaticVar obj2 = new JavaStaticVar();
		JavaStaticVar.print();
		JavaStaticVar.print();
		obj1.print();
		obj2.print();
		
		AccessSpecifiers obj = new AccessSpecifiers();
		//System.out.println(obj.name);
	}
}
