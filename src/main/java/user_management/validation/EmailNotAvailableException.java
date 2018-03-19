package user_management.validation;

public class EmailNotAvailableException extends Exception{

    public EmailNotAvailableException(){

    }
    public EmailNotAvailableException(String message){
        super(message);
    }
}
