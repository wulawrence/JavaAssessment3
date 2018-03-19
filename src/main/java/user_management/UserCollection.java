package user_management;

import java.util.ArrayList;
import java.util.Iterator;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {
        Iterator<User> iterator = this.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        Iterator<User> iterator = this.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if (user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) {
        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
