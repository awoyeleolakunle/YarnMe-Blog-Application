package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;
    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setUserName("username");
        user.setPassword("password");


    }

    @Test
    public void saveOneUserTest(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void saveOneUser_idOfUserIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
    }

    @Test
    public void saveTwoUsersWithSameId_CountIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1,userRepository.count());
        savedUser.setLastName("PriestessHood");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void saveOneUser_findUserByIdTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test
    public void savedOneUser_deleteOneUser_countIsZeroTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getId());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }
}