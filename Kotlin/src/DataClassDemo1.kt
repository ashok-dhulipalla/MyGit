class DataClassDemo1 {
}
fun main(args: Array<String>){
	var book:Book = Book("seven hills",2019,"Ashok")
	book.fun1()
	book.name= "212122"
	println(book.name)
	var book1= book.copy()
	println(book1)
	//can use inbuild functions like toString, hashcode, copy
}
data class Book(var name:String,var year:Int,var author:String){
	fun fun1(){
		println("aaaaaa")
	}
	
}