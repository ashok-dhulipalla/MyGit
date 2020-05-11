class ControlFlow {
}
fun main(args : Array<String>)
{
	val a:Int = 5
   val b:Int = 2
   var max: Int
   
   if (a > b) {
      max = a
   } else {
      max = b
   }
   println("Maximum of a or b is " +max)
 
   // As expression 
   max = if (a > b) a else b
	println("Maximum of a or b is " +max)
	
	   val x:Int = 2
   when (x) {
      1 -> println("x = = 1")
      2 -> println("x = = 2")
      
      else -> { // Note the block
         println("x is neither 1 nor 2")
      }
   }
	   when (x) {
      1,2 -> println(" Value of X either 1,2")
      
      else -> { // Note the block
         println("x is neither 1 nor 2")
      }
   }
	
	
	
	val items : List<Any> = listOf("zero", "one", "two", 3,true, 1.0f)
	for(i in items) print(i)
	println()
	
	for((index,value) in items.withIndex())
		println("$index $value")
	
	
	println(doubleme(3))
	
	mylabel@for(x in 1..10){
		for(y in 1..10){
			 if(y == 5){
				println("y is 5 and break")
				break
			}
			else{
				println("continue loop")
				continue@mylabel
			}
		}
	}
	
	
}
fun doubleme(i : Int) : Int{
	return 2*i
}