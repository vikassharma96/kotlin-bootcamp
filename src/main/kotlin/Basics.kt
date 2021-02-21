import java.util.*

fun main(args: Array<String>) { // every function in kotlin return something even if not specified Unit

    val number: Int = 2;
    number.plus(2) // use primitive int as an object
    number.div(2)
    print(1.toLong())
    val boxed: Number = 1
    print(boxed.toLong())

    val b: Byte = 1
    val i: Int = b.toInt() // implicit conversion not allowed as it leads to error
    print(i)

    // variables - i) val (not changeable)    ii) var (changeable)
    var rocks: Int? = null // ? to explicit declare a variable to be null
    rocks = 2
    var listOfFish: List<String?> = listOf(null, null)
    rocks!! // !! to force a way to pass nullable type in kotlin
    listOfFish.size
    var food = 5
    val result = "$rocks Add More $food"
    // elvis operator  - checking object or variable to null before accessing and if null print other
    print(
        food?.dec() ?: 0
    )

    val numberOfFish = 50
    val numberOfPlants = 23
    if (numberOfPlants > numberOfFish) print("Good") else print("Bad")
    if (numberOfFish in 1..100) print(numberOfFish) // ranges in kotlin
    when (number) {
        0 -> println("Empty Tank")
        50 -> println("Full Tank")
        else -> println("No")
    }
    val myList = mutableListOf("tuna", "salmon", "shark")
    myList.removeAt(0)
    myList.remove("shark")
    val array = arrayOf("fish", 2)
    print(Arrays.toString(array))

    val array1 = Array(5) { it * 2 } // assign each item to its index times 2
    print(array1.asList())
    for (element in array) {
        println(element)
    }
    for ((index, element) in array.withIndex()) {
        println("$index with $element")
    }

    for (itr in 1..5) print(itr)

    feed()

    val eager = myList.filter { it[0] == 's' } // it refers to each element in the list we are calling the filter
    println(eager)

    dirtyProcessor()

}

// lambdas are anonymous function
var dirty = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun lambdas() {
    val swim = { println("swim") }
    swim()
}

fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty ->
        dirty + 50
    }
}

fun provideQuantity(): Int {
    return 2
}

fun feed(quantity: Int = provideQuantity()) { // compact function takes more time
    println(quantity)
}
