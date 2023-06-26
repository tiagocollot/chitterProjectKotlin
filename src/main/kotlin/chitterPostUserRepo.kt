/*import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PostRepository {
    private val posts: MutableList<Post> = mutableListOf()

    fun all(): List<Post> {
        return posts.sortedByDescending { it.postTime }
    }

    fun create(post: Post) {
        posts.add(post)
    }
}


class UserRepository {
    private val users: MutableList<User> = mutableListOf()
    private var currentUser: User? = null

    fun signUp(name: String, username: String, email: String, password: String) {
        val newUser = User(users.size + 1, name, username, email, password)
        users.add(newUser)
    }

    fun logIn(username: String, password: String): Boolean {
        val user = users.find { it.username == username && it.password == password }
        if (user != null) {
            currentUser = user
            return true
        }
        return false
    }

    fun logOut() {
        currentUser = null
    }

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
    val post1 = createPost("Hello, Chitter!")
    postRepository.create(post1)

    // Post another message
    val post2 = createPost("This is my second peep.")
    postRepository.create(post2)

    // Retrieve all peeps in reverse chronological order
    val allPosts = postRepository.all()
    println("All Peeps:")
    allPosts.forEach { println(it) }

    // Log out of Chitter
    userRepository.logOut()
    println("Logged out")

    // Attempt to post a message after logging out
    val post3 = createPost("Trying to post after logging out.")
    postRepository.create(post3) // This should not be added

    // Retrieve all peeps again
    val allPostsAfterLogOut = postRepository.all()
    println("All Peeps after logging out:")
    allPostsAfterLogOut.forEach { println(it) }
}

private fun createPost(content: String): Post {
    val postRepository = PostRepository()
    val userRepository = UserRepository()
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val formattedDateTime = currentDateTime.format(formatter)
    val currentUser = userRepository.getCurrentUser()
    val postId = postRepository.all().size + 1
    return Post(postId, content, currentDateTime, currentUser!!)
}
*/