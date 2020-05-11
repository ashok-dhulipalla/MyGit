import com.ash.test.TestPackage

class ClassAndObjects {
}
class MyClass{
	private var name:String= "Ashok Kumar Dhulipalla"
	
	fun print(){
		println(name)
		println(InnerClass().foo1())
	}
	
	class Nested{
		fun foo() = "SkillSetGo is Educational channel"
	}
	
	inner class InnerClass{
		fun foo() = MyClass.Nested().foo()
		fun foo1() = name
	}
}
fun main(args : Array<String>){
	
	var obj= MyClass()
	obj.print()
	
	var ret= MyClass.Nested().foo();
	println(ret)
	
	var human:Human= object:Human{
		override fun think(){
			println("overrided method in anonymous class")
		}
	}
	human.think()

	var map : favMap= favMap()
	map.put("abc","def")
	println(map.get("abc"))
	
	var o : TestPackage= TestPackage()
	
}
interface Human{
	fun think()
}
typealias favMap= HashMap<String,String>