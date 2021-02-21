open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) : Any() {
    /*
    var length: Int = length
    var width: Int = width
    var height: Int = height
    */

    init {
        // it works just like constructor and we can create multiple init block
        // it always run before any secondary constructor
    }

    open var water = volume * 0.9

    constructor(numberOfFish: Number) : this() {

    }

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    fun volume() = width * height * length / 1000
}

class TowerTank() : Aquarium() {
    override var water = volume * 0.8
}

abstract class AquariumFish{
    abstract val color: String
}

class Shark : AquariumFish(), FishAction {
    override val color: String
        get() = "grey"

    override fun eat() {
        println("eat")
    }
}

interface FishAction {
    fun eat()
}
