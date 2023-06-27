// class UserRepository
class UserRepository {
    val users: MutableList<User> = mutableListOf()
    private var currentUser: User? = null
    // Registers a new user with the provided details
    fun signUp(user: User) {
        users.add(user)
    }
    // Validates the user's credentials and logs them in if they are correct
    // Returns true if login is successful, false otherwise
    fun logIn(username: String, password: String): Boolean {
        val user = users.find { it.username == username && it.password == password }
        if (user != null) {
            currentUser = user
            return true
        }
        return false
    }
    // Logs out the current user by setting currentUser to null
    fun logOut() {
        currentUser = null
    }
    // Returns the currently logged-in user, or null if no user is logged in
    fun getCurrentUser(): User? {
        return currentUser
    }
}