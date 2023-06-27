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