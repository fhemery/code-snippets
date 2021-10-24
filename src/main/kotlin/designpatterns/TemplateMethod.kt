package designpatterns

abstract class Performer {
    fun makeAShow() {
        getOnStage()
        perform()
        sayBye()
    }

    protected abstract fun perform()

    private fun getOnStage() {
        println("Here I come!")
    }

    private fun sayBye() {
        println("Thank you, beloved audience!")
    }

}

class Dancer: Performer() {
    override fun perform() {
        println("Here I dance!")
    }
}

class IceSkater: Performer() {
    override fun perform() {
        println("Ice is my kingdom!")
    }
}

fun main() {
    IceSkater().makeAShow()
    Dancer().makeAShow()
}