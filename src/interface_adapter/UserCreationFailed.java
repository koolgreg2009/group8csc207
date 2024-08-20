package interface_adapter;

/**
 * Exception thrown when user creation fails.
 * <p>
 * This runtime exception is used to indicate that an error occurred during the process of creating a user.
 * The exception carries a message that provides more details about the failure.
 */
public class UserCreationFailed extends RuntimeException {

    /**
     * Constructs a new {@code UserCreationFailed} exception with the specified detail message.
     *
     * @param error the detail message that provides additional information about the failure
     */
    public UserCreationFailed(String error) {
        super(error);
    }
}
