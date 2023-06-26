import java.time.LocalDateTime

data class Post(
    val id: Int,
    val content: String,
    val postTime: LocalDateTime,
    val userId: Int,
    val author: String = "guest"
)