package Main;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {

    protected String name, user_type, email, password;
    protected int id;

    public User(String name, int id, String user_type, String email, String password) {
        this.id = id;
        this.name = name;
        this.user_type = user_type;
        this.email = email;
        this.password = password;
    }

    public abstract void addUser();

    public String getName() {
        return name;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", user_type=" + user_type + ", email=" + email + ", password=" + password + ", id=" + id + '}';
    }

    public static User login(int id, String password, String Type) {
        ArrayList<User> u = UserList.listOfUser();

        for (User i : u) {
            System.out.println(i.toString());
            if (i.getId() == id && i.getPassword().equals(password) && i.getUser_type().equals(Type)) {
                return i;
            }
        }

        return null;
    }
}
