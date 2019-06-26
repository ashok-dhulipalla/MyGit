package ashok.diffs;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void comparisionOperator()
    {
    	String s1 = new String("ashok");
		String s2 = new String("ASHOK");
		System.out.println(s1 = s2);
    }
    public static void nullToFunctions()
    {
    	//foo(null);
    }
	 public static void foo(String s) {
		 System.out.println("String");
	 }

	 public static void foo(StringBuffer sb){
		 System.out.println("StringBuffer");
	 }
	 
	 public static void compare(){
		 String s1 = "abc";
		 StringBuffer s2 = new StringBuffer(s1);
		 System.out.println(s1.equals(s2));
	 }
	 
	 public static void StringBuffercompare(){
		 String s1 = "abc";
		 StringBuffer s2 = new StringBuffer(s1);
		 System.out.println(s2.equals(s1));
	 }
	 
	 public static void stringconcat()
	 {
		 String s = "ONE"+1+2+"TWO"+"THREE"+3+4+"FOUR"+"FIVE"+5; 
		 System.out.println(s);
		 
		 int i = 1 + + 2 - - 3 + + 4 - - 5 + + 6;
		 int j= 10+11+12+13+14+15;
		 System.out.println(i+" "+j);
		 
		 //return (true ? null : 0);
	 }
	 
	 public static void comparepool(){
		 String s1 = "abc";
		 String s2 = "abc";
		 System.out.println(s1 == s2);
	 }
	 
	    public static void main( String[] args )
	    {
	    	//comparisionOperator();
	    	//nullToFunctions();
	    	//compare();
	    	//comparepool();
	    	//StringBuffercompare();
	    	stringconcat();
	    	//Test t= new Test();
	    }
}
class Test{
	Test t= new Test();
}
