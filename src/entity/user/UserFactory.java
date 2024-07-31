package entity.user;

/**
 * Factory interface for creating {@code AdopterUser} instances.
 * <p>
 * This interface defines a method for creating {@code AdopterUser} objects,
 * encapsulating the user creation logic and allowing for potential future
 * expansion or modification of user creation processes.
 */
public interface UserFactory {

    /**
     * Creates a new instance of {@code AdopterUser} with the specified attributes.
     *
     * <p>This method constructs an {@code AdopterUser} using the provided username,
     * password, name, email, and phone number. It is intended to encapsulate the
     * instantiation process of {@code AdopterUser} objects.
     *
     * @param username the username for the new adopter user
     * @param password the password for the new adopter user
     * @param name the full name of the new adopter user
     * @param email the email address of the new adopter user
     * @param phone the phone number of the new adopter user
     * @return a new {@code AdopterUser} instance with the specified attributes
     */
    AdopterUser createAdopter(String username, String password, String name, String email, String phone);
}
