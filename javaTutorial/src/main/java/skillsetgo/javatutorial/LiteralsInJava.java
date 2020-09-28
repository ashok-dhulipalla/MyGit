package skillsetgo.javatutorial;

public class LiteralsInJava {
	public static void main(String[] args) {
		//Literals: Any constant value 
		//		which can be assigned to the variable
		//1. Integer literals
		int decimal = 100;
		int octal = 0146;
		int hexa = 0x123F;
		int binary = 0b1001;
		System.out.println("decimal: "+decimal);
		System.out.println("octal: "+octal);
		System.out.println("hexa: "+hexa);
		System.out.println("binary: "+binary);
		//2. Floating-Point literal
		double doubleVar = 12.34;
		float floatVar = 12.34f;
		System.out.println("double: "+doubleVar);
		System.out.println("floatVar: "+floatVar);
		//3. Char literal
		char charVar = 'A';
		char intChar = 63;
		char escapeChar = '\n';
		char unicode = '\u0063';
		System.out.println("charVar: "+charVar);
		System.out.println("intChar: "+intChar);
		System.out.println("escapeChar: "+escapeChar+"-----");
		System.out.println("unicode: "+unicode);
		//4. boolean literals
		boolean boolVar = true;
		boolean boolVarFalse = false;
		//5. String literal
		String stringVar = "123456"+'A';
		System.out.println(stringVar);
	}
}
