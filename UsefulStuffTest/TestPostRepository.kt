/*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TestPostRepository {

    @Test
    fun testGetPostWhenListIsEmpty() {
        // Create an instance of PostRepository
        val postRepository = PostRepository()

        // Assert that the post retrieved from an empty repository is null
        assertNull(postRepository.find(1))
    }

    @Test
    fun testCreatePost() {
        // Create an instance of UserRepository
        val userRepository = UserRepository()

        // Create two User objects
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
        val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")

        // Add user1 and user2 to the UserRepository using the create method
        userRepository.create(user1)
        userRepository.create(user2)

        // Create an instance of PostRepository
        val postRepository = PostRepository()

        // Create two Post objects with the correct user references
        val post1 = Post(1, "Hello, Chitter!", LocalDateTime.now(), 1, userRepository.findUserNameById(1))
        val post2 = Post(2, "This is my second peep.", LocalDateTime.now(), 2, userRepository.findUserNameById(2))

        // Add post1 and post2 to the PostRepository using the create method
        postRepository.create(post1)
        postRepository.create(post2)

        // Assert that the retrieved posts match the expected posts
        assertEquals(post1, postRepository.find(1))
        assertEquals(post2, postRepository.find(2))
    }


    @Test
    fun testFindPostById() {
        // Create an instance of PostRepository
        val postRepository = PostRepository()

        // Create two Post objects
        val post1 = Post(1, "Hello, Chitter!", LocalDateTime.now(), 1, "Joana")
        val post2 = Post(2, "This is my second peep.", LocalDateTime.now(), 1, "Johny")

        // Add post1 and post2 to the PostRepository using the create method
        postRepository.create(post1)
        postRepository.create(post2)

        // Check if the retrieved post matches post1
        assertEquals(post1, postRepository.find(1))
        // Check if the retrieved post matches post2
        assertEquals(post2, postRepository.find(2))
    }

    @Test
    fun testGetAllPosts() {
        // Create an instance of PostRepository
        val postRepository = PostRepository()
        // Create an instance of UserRepository
        val userRepository = UserRepository()

        // Create two User objects
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
        val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")

        // Add user1 and user2 to the UserRepository using the create method
        userRepository.create(user1)
        userRepository.create(user2)

        // Create two Post objects
        val post1 = Post(1, "Hello, Chitter!", LocalDateTime.now(), 1, userRepository.findUserNameById(1))
        val post2 = Post(2, "This is my second peep.", LocalDateTime.now(), 2, userRepository.findUserNameById(2))

        // Add post1 and post2 to the PostRepository using the create method
        postRepository.create(post1)
        postRepository.create(post2)

        // Assert that the list of all posts in PostRepository matches the list containing post1 and post2
        assertEquals(listOf(post1, post2), postRepository.all())
    }
}
 */