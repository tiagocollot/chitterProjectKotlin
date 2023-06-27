/*
import org.junit.jupiter.api.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertNull
import org.junit.jupiter.api.Assertions.*


class PostRepositoryTest {
    @Test
    fun testAllReturnsPostsInDescendingOrder() {
        val postRepository = PostRepository()

        val post1 = "Post 1|2023-06-25 10:00:00"
        val post2 = "Post 2|2023-06-26 12:00:00"
        val post3 = "Post 3|2023-06-27 15:00:00"

        postRepository.create(post1)
        postRepository.create(post2)
        postRepository.create(post3)

        val expected = listOf(post3, post2, post1)
        val actual = postRepository.all()

        assertEquals(expected, actual)
    }

    @Test
    fun testCreateAddsPostToList() {
        val postRepository = PostRepository()

        val post1 = "New post"

        postRepository.create(post1)

        val actual = postRepository.all()

        assertTrue(actual.contains(post1))
    }
}

class UserRepositoryTest {
    @Test
    fun testSignUpAddsNewUser() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")

        userRepository.signUp(user1)

        val user = userRepository.users.find { it.username == user1.username }

        assertEquals(user?.name, "John Doe")
        assertEquals(user?.username, "johndoe")
        assertEquals(user?.email, "johndoe@example.com")
        assertEquals(user?.password, "password")
    }


    @Test
    fun testLogInWithCorrectCredentialsReturnsTrue() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")

        userRepository.signUp(user1)

        val loggedIn = userRepository.logIn(user1.username, user1.password)

        assertTrue(loggedIn)
        assertNotNull(userRepository.getCurrentUser())
    }

    @Test
    fun testLogInWithIncorrectCredentialsReturnsFalse() {
        val userRepository = UserRepository()
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")

        userRepository.signUp(user1)

        val loggedIn = userRepository.logIn(user1.username, password = "wrongpassword")

        assertFalse(loggedIn)
        assertNull(userRepository.getCurrentUser())
    }

    @Test
    fun testLogOutSetsCurrentUserToNull() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")

        userRepository.signUp(user1)

        userRepository.logIn(user1.name, user1.password)

        userRepository.logOut()

        assertNull(userRepository.getCurrentUser())
    }
}
 */