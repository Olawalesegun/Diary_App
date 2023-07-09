package exceptions;

import java.util.concurrent.ExecutionException;

public class UserLoginDetailsIncorrectException extends RuntimeException {
    public UserLoginDetailsIncorrectException(String message){
        super(message);
    }
}
