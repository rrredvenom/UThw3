package seminars.third.tdd;


public class User {

    public String name;
    public String password;
    public Boolean isAdmin;

    public User(String name, String password, Boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean isAuthenticate(String login, String pass) {
        return (login.equals(this.name) && pass.equals(this.password));
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

}
