package principles.compositionOverInheritance

open class Flyable {
    open fun fly() {
        println("Flying !")
    }
}

class Plane : Flyable() {
    override fun fly() {
        println("Turbines up !")
    }
}

class Bird : Flyable() {
    override fun fly() {
        println("Flap ! Flap !")
    }
}

open class MakingNoise {
    open fun makeNoise(): String {
        return ""
    }
}

// HOW DO WE DO NOW ?