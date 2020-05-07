class InheritanceDemo {
}
open class College(var age:Int){

    constructor(name: String, age: Int):this(age){
        println("parent class constructor")
        println("Student Name: ${name.toUpperCase()}")
        println("Student Age: $age")
    }
/*	constructor(name: String):this(23){
        println("parent class constructor")
        println("Student Name: ${name.toUpperCase()}")
    }*/
}
class Student(var ag:Int): College(ag){
    constructor(name: String,age:Int):this(43){
        println("child class constructor")
        println("Student Name: $name")
    }
}

open class MyBaseClass(var name:String,open var age:Int){
	
}
class MyChildClass(var name1:String,override var age:Int):MyBaseClass(name1,age){
	constructor(name:String):this(name,23){
		
	}
}

open class ABC {
   open fun think () {
      print("Hey!! i am thinking ")
   }
}
class BCD: ABC() { // inheritance happens using default constructor 
   override fun think() {
      print("I Am from Child")
   }
}

fun main(args:Array<String>){
}