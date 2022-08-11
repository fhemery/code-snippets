package designpatterns

enum class Team {Home, Visitor}

class RadioChannel () {
    val listeners = mutableListOf<RadioListener>()

    fun subscribe(listener:RadioListener) { listeners.add(listener) }

    fun goalScored(team: Team) { listeners.forEach{ it.updateGoal(team) } }
}

interface RadioListener{
    fun updateGoal(team: Team)
}

class HomeTeamListener: RadioListener {
    override fun updateGoal(team: Team) {
        if (team === Team.Home) println("Yes, yes, yes!") else println("No, he was offside!")
    }
}

class VisitorListener: RadioListener {
    override fun updateGoal(team: Team) {
        if (team === Team.Home) println("Morons") else println("Ah ah, take that, f******!")
    }
}

class NeutralListener: RadioListener {
    override fun updateGoal(team: Team) {
        println("Yeah, whatever")
    }
}

fun main() {
    val soccerChannel = RadioChannel()
    soccerChannel.subscribe(HomeTeamListener())
    soccerChannel.subscribe(VisitorListener())
    soccerChannel.subscribe(NeutralListener())

    soccerChannel.goalScored(Team.Home)
}