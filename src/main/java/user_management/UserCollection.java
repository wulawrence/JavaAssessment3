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

    private String emailPattern = "^([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$";
    private String passWPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])(?=.*[a-zA-Z]).{8,}$";


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
        if (!email.matches(emailPattern)){
            throw new InvalidEmailException("This email sucks");
        }
        if (password.length() < 8){
            throw new PasswordTooSimpleException("This password sucks");
        }
        if (!password.matches(passWPattern)){
            throw new PasswordTooSimpleException("This password sucks");
        }
        User newGuy = new User(findUniqueId(), name, email, password);
        this.add(newGuy);
        return newGuy.getId();
    }
    private int findUniqueId(){
        int startID = 0;
        User user;
        do{
            startID++;
            user = findById(startID);
        }
        while (!(user == null));
        return startID;
    }
}
