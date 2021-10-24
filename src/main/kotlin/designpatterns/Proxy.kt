package designpatterns

interface StatusReporter {
    fun getStatus(): String
}

class Developer: StatusReporter {
    override fun getStatus(): String {
        return """
            So, the code is almost correct, but I have a small bug on the database interface.
            I have called the DBA to help over, he's looking at it, he said he'll have it fixed 
            by tomorrow. Then we just have to ensure everything is right, and we'll be done.
        """.trimIndent()
    }
}

class DevManager: StatusReporter {
    private val devStatus = Developer().getStatus()
    override fun getStatus(): String {
        if (devStatus.contains("tomorrow")) {
            return "Will be OK tomorrow."
        }
        return "It's ongoing."
    }
}

fun iAmADirector() {
    val catherine = DevManager()

    catherine.getStatus()
    // wait for 1/2 an hour
    catherine.getStatus()
    // wait again
    catherine.getStatus()
}