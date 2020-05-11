class FunctionsDemo {
}
fun main(args:Array<String>){
	var lambda1 : (String,String) -> String = { i,j -> i+" "+j }
	println(lambda1("Ashok Kumar","Dhulipalla"))
	
	println(func1("Ashok Kumar", lambda1))
	
	var student= Student1("Ashok",25)
	val (name,age)= student
	println(name)
	println(age)
}
fun func1(suffix:String, action : (String,String)->String):String{
	return action(suffix,"Dhulipalla")
}
data class Student1(var name:String,var age:Int){
	var name1: String= name
	var age1: Int= age
}