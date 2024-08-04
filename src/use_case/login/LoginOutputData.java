package use_case.login;

import java.util.List;

import dto.pet.PetDTO;

/**
 * The LoginOutputData class encapsulates the output data of the login process.
 * It includes fields for the username and a flag indicating if the login attempt failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginOutputData {

    private final String username;
	private final List<PetDTO> pets;

    /**
     * Constructs a new LoginOutputData object with the specified details.
     *
     * @param username the username for the new login
     * @param petDtoList 
     */
    public LoginOutputData(String username, List<PetDTO> petDtoList) {
        this.username = username;
        this.pets = petDtoList;
    }

    /**
     * Returns the username of the user who attempted to log in.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

	public List<PetDTO> getPets() {
		return pets;
	}


}
