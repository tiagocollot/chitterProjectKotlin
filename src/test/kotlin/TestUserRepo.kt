import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.jupiter.api.Assertions.*

class UserRepositoryTest {
    @Test
    fun testSignUpAddsNewUser() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")
        // Sign up user1
        userRepository.signUp(user1)
        // Find the user with the matching username
        val user = userRepository.users.find { it.username == user1.username }
        // Check if the user's name is correct
        assertEquals(user?.name, "John Doe")
        // Check if the user's username is correct
        assertEquals(user?.username, "johndoe")
        // Check if the user's email is correct
        assertEquals(user?.email, "johndoe@example.com")
        // Check if the user's password is correct
        assertEquals(user?.password, "password")
    }


    @Test
    fun testLogInWithCorrectCredentialsReturnsTrue() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")

        // Sign up user1
        userRepository.signUp(user1)
        // Attempt to log in with the provided username and password
        val loggedIn = userRepository.logIn(user1.username, user1.password)
        // Check if login is successful
        assertTrue(loggedIn)
        // Check if the current user is not null
        assertNotNull(userRepository.getCurrentUser())
    }

    @Test
    fun testLogInWithIncorrectCredentialsReturnsFalse() {
        val userRepository = UserRepository()
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")
        // Sign up user1
        userRepository.signUp(user1)
        // Log in with incorrect password
        val loggedIn = userRepository.logIn(user1.username, password = "wrongpassword")
        // Check if login is unsuccessful
        assertFalse(loggedIn)
        // Check if the current user is null
        assertNull(userRepository.getCurrentUser())
    }

    @Test
    fun testLogOutSetsCurrentUserToNull() {
        val userRepository = UserRepository()

        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "password")
        // Sign up user1
        userRepository.signUp(user1)
        // Log in with user1's name and password
        userRepository.logIn(user1.name, user1.password)

        userRepository.logOut()
        // Check if the current user is null after logout
        assertNull(userRepository.getCurrentUser())
    }
}
