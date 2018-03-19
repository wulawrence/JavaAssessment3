package user_management;

import user_management.security.UserAuthenticationFailedException;

import java.lang.reflect.Field;
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
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        Iterator<User> iterator = this.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            try {
                Field matchingEmail = user.getClass().getDeclaredField(email);
                matchingEmail.setAccessible(true);
                try {
                    if (matchingEmail.get(user).equals(email)) {
                        if (user.getPassword().matches(password)) {
                            return user;
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new UserAuthenticationFailedException("Your username or password is incorrect. Please try again.");
                }
            } catch (NoSuchFieldException e) {
                throw new UserAuthenticationFailedException("Your username or password is incorrect. Please try again.");
            }
        }
        return null;
    }

    public int createUser(String name, String email, String password) {
        return 0;
    }
}
