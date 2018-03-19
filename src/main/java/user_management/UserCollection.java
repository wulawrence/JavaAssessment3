package user_management;

import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

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
        User user = findByEmail(email);
            if (user.getEmail().equals(email)) {
                if (user.getPassword().matches(password)) {
                        return user;
                    }
                }
            throw new UserAuthenticationFailedException("Your username or password is wrong. Please try again.");
    }

    public int createUser(String name, String email, String password)
            throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {

    }
}
