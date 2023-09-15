package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public List<User> users = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate(user.name, user.password)) {
            users.add(user);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void logoutExceptAdmin() {
        users.removeIf(user -> !user.getIsAdmin());
    }

}
