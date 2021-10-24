package designpatterns

data class Tournament(val name: String, val participants: List<String>, val maxParticipants: Int)

class TournamentTestBuilder {

    var name = "Tournament"
    var maxParticipants = 256
    var participants: List<String> = emptyList()

    fun withName(name: String): TournamentTestBuilder {
        this.name = name
        return this
    }

    fun withRandomParticipants(nbParticipants: Int): TournamentTestBuilder {
        val participants = mutableListOf<String>()
        for (nb in 0 until nbParticipants) {
            participants.add("Player$nb")
        }
        this.participants = participants
        return this
    }

    fun build(): Tournament {
        return Tournament(name, participants, maxParticipants)
    }

    fun withMaxParticipants(max: Int): TournamentTestBuilder {
        maxParticipants = max
        return this
    }
}

val tournament = TournamentTestBuilder().withMaxParticipants(10).withRandomParticipants(10).build()