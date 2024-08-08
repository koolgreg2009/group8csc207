package dto;

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

	public String getActivityLevel() {
		return activityLevel;
	}

	public String getBio() {
		return bio;
	}

	public String getBreed() {
		return breed;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public int getPetAge() {
		return petAge;
	}

	public int getPetID() {
		return petID;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getSpecies() {
		return species;
	}

    @Override
    public String toString() {
        return "PetDTO [owner=" + owner + ", email=" + email + ", phoneNum=" + phoneNum + ", petAge=" + petAge +
                ", breed=" + breed + ", personality=" + ", species=" + species + ", bio=" + bio +
                ", activity level=" + activityLevel + ", gender" + gender + ", location=" + location + "]";

    }
}
