import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    val postRepository = PostRepository()
    val userRepository = UserRepository()
    val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")
    // Sign up for Chitter
    userRepository.signUp(user1)

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
    // Iterate over all posts after logging out and print the first element of each post
    allPostsAfterLogOut.forEach { println(it.split("|")[0]) }
}

private fun createPost(content: String, currentUser: User): String {
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("uuuu-M-dd HH:mm:ss")
    val formattedDateTime = currentDateTime.format(formatter)
    val postId = PostRepository().all().size + 1
    return "$content|$formattedDateTime|${currentUser.username}|$postId"
}