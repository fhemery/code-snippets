package principles.solid

/*
 * Saves tournament to database
 */
class TournamentRepository()

/*
 * Contains user data
 */
class UserRepository()

/*
 * User business rules
 */
class UserService (private val userRepository: UserRepository)

/*
 * Manages business rules
 */
class TournamentService(private val tournamentRepository: TournamentRepository, userService: UserService)

/*
 * API
 */
class TournamentController(private val tournamentService: TournamentService)

fun main() {
    val ctrl = TournamentController(TournamentService(TournamentRepository(), UserService(UserRepository())))
    // What's the issue ?
}