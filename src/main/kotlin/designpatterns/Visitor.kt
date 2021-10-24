package designpatterns

interface Family {
    fun answerVrp(vrp: VRP)
}

class SingleYoungMan: Family {
    override fun answerVrp(vrp: VRP) {
        vrp.makeSpeech(this)
    }
}

class CoupleWithThreeKids: Family {
    override fun answerVrp(vrp: VRP) {
        vrp.makeSpeech(this)
    }
}

class SingleWidowWoman: Family {
    override fun answerVrp(vrp: VRP) {
        vrp.makeSpeech(this)
    }
}

class VRP () {

    fun tryToSell(families: List<Family>) {
        families.forEach{   it.answerVrp(this)  }
    }

    fun makeSpeech(youngMan: SingleYoungMan) {
        println("You definitely need this wonderful beer machine !")
    }

    fun makeSpeech(couple: CoupleWithThreeKids) {
        println("We have wonderful playground toys for your kids !")
    }

    fun makeSpeech(widow : SingleWidowWoman) {
        println("What about this magnificent tea set?")
    }
}
