package user_management.validation;

public class PasswordTooSimpleException extends Exception{

    public PasswordTooSimpleException(){

    }
    public PasswordTooSimpleException(String message){
        super(message);
    }
}
