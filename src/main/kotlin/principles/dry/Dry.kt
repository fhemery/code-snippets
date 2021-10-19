package principles.dry

interface User {
    var id: String
    var name: String
    var email: String
}

interface RegistrationUser {
    var name: String
    var password: String
    var email: String
}

// C'est tentant, non ?

interface UnifiedUser {
    var id: String
    var name: String
    var email: String
    var unifiedUser: String
}