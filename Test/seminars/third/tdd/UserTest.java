package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    /**
     * 3.6. Нужно написать класс User (пользователь) с методом аутентификации по логину и паролю,
     * (В метод передаются логин и пароль, метод возвращает true, если пароль и логин совпадают, иначе - false)
     */
    @Test
    void userCreationTrue() {
        User user = new User("userLogin", "userPass", false);
        String login = "userLogin";
        String pass = "userPass";
        assertTrue(user.isAuthenticate(login, pass));
    }

    @Test
    void userCreationFail() {
        User user = new User("userLogin", "userPass", false);
        String login = "userLogin1";
        String pass = "userPass1";
        assertFalse(user.isAuthenticate(login, pass));
    }


    /**
     * HW 3_4 <br>
     * Нужно добавить класс UserRepository (Хранилище для работы с пользователями).
     * В метод addUser передается пользователь, если он зарегистрирован (isAuthenticate возвращает true),
     * то он попадает в список пользователей.
     */

    @Test
    void testIsValidAddUser() {
        User user = new User("userLogin", "userPass", false);
        UserRepository repository = new UserRepository();
        repository.addUser(user);
        assertTrue(repository.getUsers().contains(user));
    }

    @Test
    void testIsInvalidAddUser() {
        User user1 = new User("userLogin", "userPass", false);
        User user2 = new User("userLogin2", "userPass2", false);
        UserRepository repository = new UserRepository();
        repository.addUser(user1);
        assertFalse(repository.getUsers().contains(user2));
    }

    @Test
    void testCorrectLogout() {
        User user1 = new User("userLogin1", "userPass1", false);
        User user2 = new User("userLogin2", "userPass2", true);
        User user3 = new User("userLogin3", "userPass3", false);
        UserRepository repository = new UserRepository();
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        repository.logoutExceptAdmin();
        assertTrue(repository.getUsers().contains(user2));
    }

    @Test
    void testIncorrectLogout() {
        User user1 = new User("userLogin1", "userPass1", false);
        User user2 = new User("userLogin2", "userPass2", true);
        User user3 = new User("userLogin3", "userPass3", false);
        UserRepository repository = new UserRepository();
        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
        repository.logoutExceptAdmin();
        assertFalse(repository.getUsers().contains(user1));
    }

}