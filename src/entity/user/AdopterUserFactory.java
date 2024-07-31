package entity.user;

/**
 * A factory class for creating instances of {@code AdopterUser}.
 * <p>
 * This class implements the {@code UserFactory} interface and provides a method to
 * create `AdopterUser` instances with specified details.
 */

public class AdopterUserFactory implements UserFactory {

    /**
     * Creates a new {@code AdopterUser} with the specified details.
     *
     * <p>This method constructs an `AdopterUser` using the provided username, password,
     * name, email, and phone number. It initializes the `AdopterUser` with these values
     * and sets up default values for other fields.
     *
     * @param username the username for the new adopter user
     * @param password the password for the new adopter user
     * @param name the full name of the new adopter user
     * @param email the email address of the new adopter user
     * @param phone the phone number of the new adopter user
     * @return a new {@code AdopterUser} object initialized with the provided details
     */
    @Override
    public AdopterUser createAdopter(String username, String password, String name, String email, String phone){
        return new AdopterUser(username, password, name, email, phone);
    }
}
