package skillsetgo.javatutorial;
class AccessVar {
	public static void main(String[] args) {
		AccessSpecifiers obj = new AccessSpecifiers();
		//System.out.println(obj.name);
		//-----Access Specifiers-----
		//1. Public: accessed from everywhere.
		//within class, outside class, within package 
		//and outside package.
		
		//2. Protected: The access level of a protected modifier 
		//is within the package and outside the package through child class.
		
		//3. Default: The access level of a default modifier 
		//is only within the package.
		
		//4. Private: The access level of a private modifier
		//is only within the class.
	}
}
public class AccessSpecifiers {
	private String name = "SkillSetGo";
	
	public void print() {
		AccessSpecifiers obj = new AccessSpecifiers();
		System.out.println(obj.name);
	}
}
