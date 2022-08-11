package principles.abstractionlevel

class Car {
    private var blinkerState = BlinkerState.Off
    private var turningAngle = 0
    private var thrust = 50.0

    fun turnRight() {
        toggleBlinker(BlinkerState.On)
        for (i in 0 until 90) {
            thrust *= 0.99
            turningAngle += 1
        }
        toggleBlinker(BlinkerState.Off)
    }

    private fun toggleBlinker(state: BlinkerState) {
        blinkerState = state
    }
}

enum class BlinkerState {
    On, Off
}