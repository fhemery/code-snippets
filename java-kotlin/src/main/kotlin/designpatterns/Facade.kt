package designpatterns

class DriverFacade() {
    private val wheelSystem = WheelSystem()
    private val gasSystem = GasSystem()
    private val brakeSystem = BrakeSystem()

    fun turnRight() {
        wheelSystem.turnRight()
    }

    fun turnLeft() {
        wheelSystem.turnLeft()
    }

    fun thrust() {
        gasSystem.goFaster()
    }

    fun brake() {
        brakeSystem.brake()
    }
}

class WheelSystem() {
    fun turnRight() { TODO() }
    fun turnLeft() { TODO() }
}

class GasSystem() {
    fun goFaster() { TODO() }
}

class BrakeSystem() {
    fun brake() { TODO() }
}