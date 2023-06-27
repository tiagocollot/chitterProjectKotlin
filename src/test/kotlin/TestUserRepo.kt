import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import org.junit.jupiter.api.Assertions.*

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
