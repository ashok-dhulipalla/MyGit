class DataTypes {
}
fun main(args : Array<String>)
{
   val a: Int = -1
   val d: Double = 100.00
   val f: Float = 100.0234f
   val l: Long = 1000000004
   val s: Short = 10
   val b: Byte = 1
   
   println("Your Int Value is "+a);
   println("Your Double  Value is "+d);
   println("Your Float Value is "+f);
   println("Your Long Value is "+l);
   println("Your Short Value is "+s);
   println("Your Byte Value is "+b);
	
   val letter: Char    // defining a variable 
   letter = 'A'        // Assigning a value to it 
   println("$letter")
	
   val letterb: Boolean   // defining a variable 
   letterb = true         // Assinging a value to it 
   println("Your character value is "+"$letterb")
	
   var rawString :String  = "I am Raw String!"
   val escapedString : String  = "I am escaped String!\n"
   println("Hello!"+escapedString)
   println("Hey!!"+rawString)
	
   val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
	
   println("Hey!! I am array Example"+numbers[2])
	
   val numbersM: MutableList<Int> = mutableListOf(1, 2, 3) //mutable List 
   val readOnlyView: List<Int> = numbersM                  // immutable list 
   println("my mutable list--"+numbersM)        // prints "[1, 2, 3]" 
   numbersM.add(4) 
   println("my mutable list after addition --"+numbersM)        // prints "[1, 2, 3, 4]" 
   println(readOnlyView)     
  // readOnlyView.add(4)    // ⇒ does not compile  
// gives error
	
   val items= listOf(1,2,3,4,5)
	println(items.first())
	println(items.last())
	println(items.filter { it%2 == 0 })
	
	val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
   println(readWriteMap["bar"])
	
	val strings = hashSetOf("a", "b", "c", "c")
   println("My Set Values are"+strings)
	
	val i: Int= 2
	for(j in 1..5)
		print(j)
	if(i in 3..8)
		println("we found your number")
	else
		println("number not found")
	
	
	
	
	
	
	
	
	
	
	
}