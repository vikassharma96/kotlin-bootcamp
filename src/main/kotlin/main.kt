fun main() {
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("${myAquarium.height} ${myAquarium.width}")
    myAquarium.length = 100
    println("${myAquarium.length}")

    val myAquarium2 = Aquarium(numberOfFish = 10)
    println(myAquarium.volume)

    delegate()
}

// composition, interface delegation
fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishActions {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus : FishActions, FishColor by GoldColor {
    override fun eat() {
        println("eat algae")
    }

    override val color = "gold"

}

object GoldColor : FishColor {
    override val color: String
        get() = "gold"

}

data class Decoration(val rocks: String)

fun pair() {
    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println(tool + use)
}

const val rocks = 2

class MyClass {
    companion object {
        const val CONSTANTS = "constants inside companion"
    }
}

// extension function
fun String.hasSpaces(): Boolean {
    val found: Char? = this.find() { it == ' ' }
    return found != null
}

// fun String.hasSpaces() = find() { it == ' ' } != null

class MyGenericClass<T> {
    fun add(item: T) {}

    fun get(): T {
        TODO("implement")
    }
}
