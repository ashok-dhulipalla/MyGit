class ArraysDemo {
}
fun main(args:Array<String>){
	var arr1= Array<Int>(5){0}
	
	var myArray1 = arrayOf(1,10,4,6,15)  
	var myArray2 = arrayOf<Int>(1,10,4,6,15)  
	val myArray3 = arrayOf<String>("Ajay","Prakesh","Michel","John","Sumit")  
	var myArray4= arrayOf(1,10,4, "Ajay","Prakesh")
	
	var myArray5: IntArray = intArrayOf(5,10,20,12,15)
	
	for(e in arr1){
		println(e)
	}
}