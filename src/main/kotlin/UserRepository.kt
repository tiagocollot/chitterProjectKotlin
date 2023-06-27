// Define the UserRepository class
class UserRepository {
    // Create a mutable list to store User objects
    private val users: MutableList<User> = mutableListOf()
    // Return a read-only copy of the list of users
    fun all(): List<User> {
        return users.toList()
    }
    // Add a user to the list

    fun create(user: User) {
        users.add(user)
    }
    // Find a user by their ID
    fun find(userId: Int): User? {
        return users.find { it.id == userId }
    }

    fun findUserNameById(userId: Int): String? {
        val user = find(userId)
        return user?.username
    }
    // Find a user associated with a specific post ID
    fun findWithPost(postId: Int): User? {
        // Find the user whose ID matches the post ID
        val postUser = users.find { it.id == postId }
        return if (postUser != null) {
            // Create a new User object with the relevant information
            User(postUser.id, postUser.name, postUser.username, postUser.email, postUser.password)
        } else {
            // Return null if no user is found
            null
        }
    }
}


// Example usage
fun main() {
    val userRepository = UserRepository()

    // Creating a new user
    val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
    val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")
    userRepository.create(user1)
    userRepository.create(user2)

    // Finding a specific user by ID
    val userIdToFind = 1
    val foundUser = userRepository.find(userIdToFind)
    if (foundUser != null) {
        println("\nFound User:")
        println(foundUser)
    } else {
        println("\nUser with ID $userIdToFind not found.")
    }

    // Finding a user associated with a specific post
    val postIdToFind = 1
    val userWithPost = userRepository.findWithPost(postIdToFind)
    if (userWithPost != null) {
        println("\nUser associated with Post ID $postIdToFind:")
        println(userWithPost)
    } else {
        println("\nUser associated with Post ID $postIdToFind not found.")
}
    // Retrieving all users
    val allUsers = userRepository.all()
    println("\nAll Users:")
    allUsers.forEach { println(it) }
    }
