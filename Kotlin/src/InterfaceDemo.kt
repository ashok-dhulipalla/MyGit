class InterfaceDemo {
}
interface MyInterface{
	var name: String
	fun absMethod()
	fun defaultMethod(age:Int){
		println(age)
	}
}

interface MyInterface1{
	var name: String
	fun absMethod1()
	fun defaultMethod(age:Int){
		println(age)
	}
}

class MyImpClass : MyInterface, MyInterface1{
	override var name: String= "Ashok"
	override fun absMethod(){
		
	}
	override fun absMethod1(){
		
	}
	override fun defaultMethod(age:Int){
		println(age)
	}
}