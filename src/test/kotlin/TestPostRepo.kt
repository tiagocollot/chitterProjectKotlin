import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class PostRepositoryTest {
    @Test
    fun testAllReturnsPostsInDescendingOrder() {
        val postRepository = PostRepository()

        val post1 = "Post 1|2023-06-25 10:00:00"
        val post2 = "Post 2|2023-06-26 12:00:00"
        val post3 = "Post 3|2023-06-27 15:00:00"

        // Create post1
        postRepository.create(post1)
        // Create post2
        postRepository.create(post2)
        // Create post3
        postRepository.create(post3)

        val expected = listOf(post3, post2, post1)
        val actual = postRepository.all()

        // Check if the posts are returned in descending order
        assertEquals(expected, actual)
    }

    @Test
    fun testCreateAddsPostToList() {
        val postRepository = PostRepository()

        val post1 = "New post"

        // Create a new post
        postRepository.create(post1)

        val actual = postRepository.all()

        // Check if the created post is in the list
        assertTrue(actual.contains(post1))
    }
}