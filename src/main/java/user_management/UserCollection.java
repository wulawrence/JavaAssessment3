package user_management;

import user_management.security.Password;
import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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
            throws PasswordTooSimpleException, EmailNotAvailableException, InvalidEmailException {
        Iterator<User> iterator = this.iterator();
        User user = iterator.next();
        if (user.getEmail().equals(email)){
            throw new EmailNotAvailableException("This email is taken by another user.");
        }
        if (!email.matches("[A-Z0-9._%!&#$()*+-]+")){
            throw new InvalidEmailException("This email sucks");
        }
        if (!password.matches("(?=.*[a-z])") || !password.matches("(?=.*[A-Z])") ||
                !password.matches("(?=.*[0-9])") || !password.matches("(?=.[!@#\\$%\\^&])") ||
                !password.matches("(?=.{8,})")){
            throw new PasswordTooSimpleException("This password sucks");
        }
        return 0;
    }

}
