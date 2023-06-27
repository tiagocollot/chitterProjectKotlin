import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// class PostRepository
class PostRepository {
    private val posts: MutableList<String> = mutableListOf()
    // Retrieves all posts and sorts them in descending order based on the post timestamp
    fun all(): List<String> {
        return posts.sortedByDescending {
            LocalDateTime.parse(it.split("|")[1], DateTimeFormatter.ofPattern("uuuu-M-dd HH:mm:ss"))
        }
    }
    // Creates a new post and adds it to the list of posts
    fun create(content: String) {
        posts.add(content)
    }
}
// class UserRepository
class UserRepository {
    private val users: MutableList<User> = mutableListOf()
    private var currentUser: User? = null
    // Registers a new user with the provided details
    fun signUp(name: String, username: String, email: String, password: String) {
        val newUser = User(users.size + 1, name, username, email, password)
        users.add(newUser)
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
fun main() {
    val postRepository = PostRepository()
    val userRepository = UserRepository()

    // Sign up for Chitter
    userRepository.signUp("John Doe", "johndoe", "johndoe@example.com", "password")

    // Log in to Chitter
    val loggedIn = userRepository.logIn("johndoe", "password")
    if (loggedIn) {
        println("Logged in as ${userRepository.getCurrentUser()?.username}")
    } else {
        println("Invalid username or password")
        return
    }

    // Post a message (peep) to Chitter
    val post1 = createPost("Hello, Chitter!", userRepository.getCurrentUser()!!)
    postRepository.create(post1)

    // Post another message
    val post2 = createPost("This is my second peep.", userRepository.getCurrentUser()!!)
    postRepository.create(post2)

    // Retrieve all peeps in reverse chronological order
    val allPosts = postRepository.all()
    println("All Peeps:")
    allPosts.forEach { println(it.split("|")[0]) }

    // Log out of Chitter
    userRepository.logOut()
    println("Logged out")

    // Attempt to post a message after logging out
    val currentUser = userRepository.getCurrentUser()
    if (currentUser != null) {
        val post3 = createPost("Trying to post after logging out.", currentUser)
        postRepository.create(post3) // This should not be added
    } else {
        println("Cannot create post after logging out. User is null.")
    }

    // Retrieve all peeps again
    val allPostsAfterLogOut = postRepository.all()
    println("All Peeps after logging out:")
    allPostsAfterLogOut.forEach { println(it.split("|")[0]) }
}

private fun createPost(content: String, currentUser: User): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("uuuu-M-dd HH:mm:ss")
    val formattedDateTime = currentDateTime.format(formatter)
    val postId = PostRepository().all().size + 1
    return "$content|$formattedDateTime|${currentUser.username}|$postId"
}