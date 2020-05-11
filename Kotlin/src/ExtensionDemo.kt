class ExtensionDemo {
}
class Alien{
	fun fun1(){
		println("normal function")
	}
}
fun main(args:Array<String>){
	var obj1= Alien()
	obj1.fun1()
	obj1.fun2()
}
fun Alien.fun2():Int{
	println("extension function")
	return 3;
}