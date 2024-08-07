package use_case.adopt;

/**
 * Data class for holding information about a pet adoption output.
 *
 * <p>This class encapsulates the details of a pet adoption, including the pet owner's name, email,
 * phone number, and the pet's ID. It provides getter methods to access these fields.
 */
public class AdoptOutputData {
    private final String petOwner;
    private final String ownerEmail;
    private final String ownerPhone;
    private final String petName;

    /**
     * Constructs an {@code AdoptOutputData} object with the specified details.
     *
     * @param petOwner the name of the pet owner
     * @param ownerEmail the email address of the pet owner
     * @param ownerPhone the phone number of the pet owner
     * @param petName the ID of the pet
     */
    public AdoptOutputData(String petOwner, String ownerEmail, String ownerPhone, String petName){
        this.petOwner = petOwner;
        this.ownerEmail = ownerEmail;
        this.ownerPhone = ownerPhone;
        this.petName = petName;

    }

    /**
     * Returns the name of the pet owner.
     *
     * @return the pet owner's name
     */
    public String getPetOwner() {
        return petOwner;
    }

    /**
     * Returns the email address of the pet owner.
     *
     * @return the pet owner's email address
     */
    public String getOwnerEmail() {
        return ownerEmail;
    }

    /**
     * Returns the phone number of the pet owner.
     *
     * @return the pet owner's phone number
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }

    /**
     * Returns the ID of the pet.
     *
     * @return the pet's ID
     */
    public String getID() {
        return petName;
    }
}
