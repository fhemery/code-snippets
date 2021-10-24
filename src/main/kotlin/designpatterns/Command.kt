package designpatterns

class Button {
    fun click() {
        val command = ClientUpdateCommand("123", "Bob")
        command.execute()
    }
}

interface Command {
    fun execute()
}

class ClientUpdateCommand(val clientId: String, val name: String) : Command {
    private val clientUpdateService = ClientUpdateService()
    override fun execute() {
        clientUpdateService.updateClient(clientId, name)
    }
}

class ClientUpdateService() {
    fun updateClient(id: String, name: String) {

    }
}

fun main() {
    val button = Button()
    button.click()
}
