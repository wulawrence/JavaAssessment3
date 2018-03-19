package user_management.security;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private final static int workload = 12;
    private String hash;

    public Password(String password) {
        this.hash = hashPassword(password);
    }

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hash = BCrypt.hashpw(password_plaintext, salt);
        return hash;
    }

    public boolean matches(String password_plaintext) {
        // Note: normally a match method would include a check to see if the hash is valid but for this exam we will
        //       assume that all the passwords we will check are valid. All of the password hashes in the users.json
        //       file are valid so there should be no worry about this as long as you don't overwrite them manually.
        String hashToCheckAgainst = this.hash;
        // hash.check(password, hashToCheckAgainst)
        return BCrypt.checkpw(password_plaintext, hashToCheckAgainst);
        // return true if check is true
        // return false if check is false
    }

    public String getHash() {
        return this.hash;
    }
}
