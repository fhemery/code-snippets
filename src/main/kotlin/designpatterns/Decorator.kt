package designpatterns

enum class Side(val value: String) {Left("left"), Right("right")}
interface MisterPotato {
    fun assemble()
}

class Body : MisterPotato {
    override fun assemble() {
        println("I have a body")
    }
}


class Arm(private val side: Side, private val misterPotato: MisterPotato): MisterPotato {
    override fun assemble() {
        misterPotato.assemble()
        println("I have a ${side.value} arm")
    }
}

class Leg(private val side: Side, private val misterPotato: MisterPotato): MisterPotato {
    override fun assemble() {
        misterPotato.assemble()
        println("I have a ${side.value} leg")
    }
}

class Hat(private val color: String, private val misterPotato: MisterPotato): MisterPotato {
    override fun assemble() {
        misterPotato.assemble()
        println("I have a $color hat")

    }

}

fun main() {
    val misterPotato: MisterPotato = Hat("blue", Leg(Side.Left, Arm(Side.Right, Body())))
    misterPotato.assemble()
}