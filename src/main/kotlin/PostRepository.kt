
import java.time.LocalDateTime
class PostRepository {
    private val posts: MutableList<Post> = mutableListOf()

    fun all(): List<Post> {
        return posts.toList()
    }

    fun create(post: Post) {
        posts.add(post)
    }

    fun find(postId: Int): Post? {
        return posts.find { it.id == postId }
    }
}

fun main() {
    val postRepository = PostRepository()
    val userRepository = UserRepository()
    // Creating sample posts
    val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
    val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")
    userRepository.create(user1)
    userRepository.create(user2)

    val post1 = Post(1, "First post", LocalDateTime.now(), 1, userRepository.findUserNameById(1))
    val post2 = Post(2, "Second post", LocalDateTime.now(), 2, userRepository.findUserNameById(2))

    // Adding posts to the repository
    postRepository.create(post1)
    postRepository.create(post2)

    // Retrieving all posts
    val allPosts = postRepository.all()
    println("All Posts:")
    allPosts.forEach { println(it) }

    // Finding a specific post by ID
    val postIdToFind = 1
    val foundPost = postRepository.find(postIdToFind)
    if (foundPost != null) {
        println("\nFound Post:")
        println(foundPost)
    } else {
        println("\nPost with ID $postIdToFind not found.")
    }
}

