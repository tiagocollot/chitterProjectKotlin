import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TestUserRepository {

    @Test
    fun testGetUserWhenListIsEmpty() {
        // Create an instance of MusicLibrary
        val user = UserRepository()
        // Assert that the track retrieved from an empty library is null
        assertNull(user.find(1))
    }

    @Test
    fun testCreateUser() {
        // Create an instance of UserRepository
        val user = UserRepository()
        // Create two User objects
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
        val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")
        // Add user1 and user2 to the UserRepository using the create method
        user.create(user1)
        user.create(user2)

        assertEquals(user1, User(1, "John Doe", "johndoe", "johndoe@example.com", "232323"))
        assertEquals(user2, User(2, "Doe", "doe", "doe@example.com", "121232"))
    }


    @Test
    fun testFindUserById() {
        // Create an instance of UserRepository
        val user = UserRepository()
        // Create two User objects
        val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
        val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")
        // Add user1 and user2 to the UserRepository using the create method
        user.create(user1)
        user.create(user2)
        // Check if the retrieved user matches user1
        assertEquals(user1, user.find(1))
        // Check if the retrieved user matches user2
        assertEquals(user2, user.find(2))

    }

    @Test
    fun getAllUsers() {
       // Creates an instance of UserRepository and assigns it to the variable user
       val user = UserRepository()
       // Create two User objects
       val user1 = User(1, "John Doe", "johndoe", "johndoe@example.com", "232323")
       val user2 = User(2, "Doe", "doe", "doe@example.com", "121232")
       // Add user1 and user2 to the UserRepository using the create method 
       user.create(user1)
       user.create(user2)
       // Assert that the list of all users in UserRepository matches the list containing user1 and user2
       assertEquals(listOf(user1, user2), user.all())
    }
}