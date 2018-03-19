package user_management.security;

import user_management.User;

public class Authenticator {
    public static boolean authenticate(User user, String passwordToCheck) {
        Password pass = user.getPassword();
        return pass.matches(passwordToCheck);
    }
}

