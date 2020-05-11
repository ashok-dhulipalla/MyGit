class Constructors(var name:String,var age:Int) {
	//primary constructor
	//secondary constructors
}
class ConstructorDefaults(var name:String= "Ashok",var age:Int = 24) {
	init{
		name+= "suffixName"
		age+= 10
	}
}
class ConstructorSecondary {
	var message = ""
	var name= ""
	var age=0
	//we must call primary constructor in secondary constructor
	//we have call as this() if there is no primary constructor
	constructor(name:String,message:String,age:Int){
		this.message= message
	}
}
fun main(args:Array<String>)
{
	var obj1 = Constructors("Ashok",25)
	println(obj1.name)
	println(obj1.age)
	
	var obj2 = ConstructorDefaults()
	var obj3 = ConstructorDefaults("Kumar")
	println(obj2.name)
	println(obj2.age)
	println(obj3.name)
	println(obj3.age)
	
	var obj4= ConstructorSecondary("abc","message",54)
	println(obj4.name)
	println(obj4.message)
	println(obj4.age)
}