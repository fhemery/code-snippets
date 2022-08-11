package designpatterns

class UserInfo {
    var userSecurityToken: String = ""

    companion object {
        private var instance: UserInfo? = null

        fun getInstance(): UserInfo {
            // PATTERN : lazy initializer
            if (instance == null) {
                instance = UserInfo()
            }
            return instance!!
        }
    }
}

class Manager() {

    fun init(userToken: String) {
        UserInfo.getInstance().userSecurityToken = userToken
    }

    fun doSthg(): String {
        // Do sthg important
        return UserInfo.getInstance().userSecurityToken
    }
}

fun usage(): String {
    val manager = Manager()
    manager.init("12345")

    // Go do an external call for any reason

    return manager.doSthg()
}
