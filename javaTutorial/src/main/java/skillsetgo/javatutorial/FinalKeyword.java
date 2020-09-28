package skillsetgo.javatutorial;
class Parent {
	private final String name;
	Parent() {
		name = "SkillSetGo";
	}
	public void print() {
		//name = "SkillSetGo";
		System.out.println(name);
	}
}
class Child extends Parent {
	public void print() {
		//name = "SkillSetGo";
		//System.out.println(name);
	}
}
public class FinalKeyword {
	public static void main(String[] args) {
		final String name;
		//final in java---It restricts the user
		//variable: can be initialized only once
		//class: Can not to inherit
		//method: can not override
		
	}
}
