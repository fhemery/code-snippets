package designpatterns.antipatterns

class Unit {

    var currentHealth: Int = 50
    var maxHealth: Int = 100
    var x = 0
    var y = 0
    var speed: Int = 35
    var army: Int = 1
    var squad : Squad? = null
    // And so the fields goes on...


    fun move(newX: Int, newY: Int) {
        // A lot of lines to make unit move
    }

    fun attack(otherUnit: Unit) {
        // a lot of lines to check if unit can attack and do it
    }

    fun rest() {
        // a function to diminish fatigue
    }

    /* fun build / heal / demolish / bombard / observe / transmit ... */
}

class Squad
