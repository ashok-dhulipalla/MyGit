class Nullable {
	var name:String= "AShok"
}
fun main(args:Array<String>)
{
	var str:String? = null; //need to add ? If we want to add null posibility
	val i:Int = 3
	if(i == null){//always false
		println("This won't execute because i is not nullable")
	}

	var a : String? = null
	var newStr : String? = "Kotlin Null Safety"
	newStr = null
	println(newStr)
	
	var onj1 :Nullable= Nullable()
}