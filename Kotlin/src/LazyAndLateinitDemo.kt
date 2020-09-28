class Demo {
	lateinit var name: String
	
	val lazyDemoVar: String by lazy {
		println("-------")
		"SkillSetGo lazy variable"
	}
	
	fun init() {
		lateinit var variable1: String
		val variable2: String
		println(variable1)
		name = "SkillSetGo"
	}
	fun print() {
		println(name)
		println(lazyDemoVar)
	}
}
fun main(args: Array<String>) {
	//Lazy and Lateinit

	val demo = Demo()
	demo.init()
	demo.print()
	//Lateinit: Variable which we don't want to
	//initialise while declaration
	
	//Lazy: Variable which has initialisation value
	//but not initialised until it is used.
}