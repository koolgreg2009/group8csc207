package dto;

/**
 * Data Transfer Object (DTO) for representing a pet.
 * This class encapsulates all the details about a pet, including its ID, name, breed, and other attributes.
 */
public class PetDTO {
	private final String activityLevel;
	private final String bio;
	private final String breed;
	private final String email;
	private final String gender;
	private final String imgUrl;
	private final String location;
	private final String name;
	private final String owner;
	private final int petAge;
	private final int petID;
	private final String phoneNum;
	private final String species;

	/**
	 * Constructs a new {@link PetDTO} with the specified details.
	 *
	 * @param petID          the unique identifier for the pet
	 * @param name           the name of the pet
	 * @param breed          the breed of the pet
	 * @param gender         the gender of the pet
	 * @param species        the species of the pet
	 * @param petAge         the age of the pet in months
	 * @param bio            a brief description or biography of the pet
	 * @param owner          the name of the pet's owner
	 * @param email          the email address of the pet's owner
	 * @param phoneNum       the phone number of the pet's owner
	 * @param activityLevel  the activity level of the pet (e.g., high, medium, low)
	 * @param location       the location where the pet is currently situated
	 * @param imgUrl         the URL of the pet's image
	 */
	public PetDTO(int petID, String name, String breed, String gender, String species, int petAge, String bio,
			String owner, String email, String phoneNum, String activityLevel, String location, String imgUrl) {
		this.petID = petID;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.species = species;
		this.petAge = petAge;
		this.bio = bio;
		this.owner = owner;
		this.email = email;
		this.phoneNum = phoneNum;
		this.activityLevel = activityLevel;
		this.location = location;
		this.imgUrl = imgUrl;
	}

	/**
	 * Returns the activity level of the pet.
	 *
	 * @return the activity level of the pet
	 */
	public String getActivityLevel() {
		return activityLevel;
	}

	/**
	 * Returns the biography or description of the pet.
	 *
	 * @return the biography of the pet
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Returns the breed of the pet.
	 *
	 * @return the breed of the pet
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Returns the email address of the pet's owner.
	 *
	 * @return the email address of the pet's owner
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the gender of the pet.
	 *
	 * @return the gender of the pet
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Returns the URL of the pet's image.
	 *
	 * @return the URL of the pet's image
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * Returns the location where the pet is currently situated.
	 *
	 * @return the location of the pet
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Returns the name of the pet.
	 *
	 * @return the name of the pet
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the name of the pet's owner.
	 *
	 * @return the owner of the pet
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Returns the age of the pet in months.
	 *
	 * @return the age of the pet
	 */
	public int getPetAge() {
		return petAge;
	}

	/**
	 * Returns the unique identifier of the pet.
	 *
	 * @return the ID of the pet
	 */
	public int getPetID() {
		return petID;
	}

	/**
	 * Returns the phone number of the pet's owner.
	 *
	 * @return the phone number of the pet's owner
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Returns the species of the pet.
	 *
	 * @return the species of the pet
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Returns a string representation of the {@link PetDTO}.
	 *
	 * @return a string representation of the {@link PetDTO}
	 */
    @Override
    public String toString() {
        return "PetDTO [owner=" + owner + ", email=" + email + ", phoneNum=" + phoneNum + ", petAge=" + petAge +
                ", breed=" + breed + ", personality=" + ", species=" + species + ", bio=" + bio +
                ", activity level=" + activityLevel + ", gender" + gender + ", location=" + location + "]";

    }
}
