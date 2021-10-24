package designpatterns

class PassportFormAndDocuments(val form: Any, val documents: Any)

interface Administration {
    fun validatePassportRequest(passportRequest: PassportFormAndDocuments): Boolean
}

class TheManAtTheFrontDesk(val nextService: Administration?) : Administration {
    override fun validatePassportRequest(passportRequest: PassportFormAndDocuments): Boolean {
        if (areAllFormsFilled(passportRequest.form)) {
            throw Exception("There is a field missing")
        }
        return nextService?.validatePassportRequest(passportRequest) ?: true
    }

    private fun areAllFormsFilled(form: Any): Boolean {
        TODO("Check if all forms are filled")
    }

}

class LadyInTheOffice(val nextService: Administration?): Administration {
    override fun validatePassportRequest(passportRequest: PassportFormAndDocuments): Boolean {
        TODO("Check if the documents are correct or return false")
        return nextService?.validatePassportRequest(passportRequest) ?: true
    }
}

class ImmigrationService(val nextService: Administration?): Administration {
    override fun validatePassportRequest(passportRequest: PassportFormAndDocuments): Boolean {
        TODO("Check person asking has french nationality")
        return nextService?.validatePassportRequest(passportRequest) ?: true
    }
}

fun main () {
    val chain = TheManAtTheFrontDesk(LadyInTheOffice(ImmigrationService(null)))
    chain.validatePassportRequest(PassportFormAndDocuments("form", "documents"))
}