package app.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super(String.format("User %s not found", id));
    }

    public UserNotFoundException(String login) {
        super(String.format("User by login %s not found", login));
    }

}
