package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents all the information associated with a pet.
 * <p>
 * This class contains details about a pet, including its owner, contact information,
 * identification, physical attributes, personality traits, and availability status.
 * It provides methods to access and modify these details.
 */

public class Pet {
    private final String owner;
    private final String email;
    private final String phoneNum;
    private final int petID;
    private final String species;
    private final int petAge;
    private final String breed;
    private List<String> personality = new ArrayList<>();
    private String bio;
    private final String activityLevel;
    private final String gender;
    private final String location;
    private boolean isAvailable;

    /**
     * Constructs a {@code Pet} object with the specified details.
     *
     * @param owner the name of the pet's owner
     * @param email the email address of the pet's owner
     * @param phoneNum the phone number of the pet's owner
     * @param petID the unique identifier for the pet
     * @param species the species of the pet
     * @param petAge the age of the pet
     * @param breed the breed of the pet
     * @param personality a list of the pet's personality traits
     * @param gender the gender of the pet
     * @param activityLevel the activity level of the pet
     * @param bio a brief biography of the pet
     * @param location the location of the pet
     * @param available the availability status of the pet
     */
    public Pet(@JsonProperty("owner") String owner,
               @JsonProperty("email") String email,
               @JsonProperty("phoneNum") String phoneNum,
               @JsonProperty("petID") int petID,
               @JsonProperty("species") String species,
               @JsonProperty("petAge") int petAge,
               @JsonProperty("breed") String breed,
               @JsonProperty("personality") List<String> personality,
               @JsonProperty("gender") String gender,
               @JsonProperty("activityLevel") String activityLevel,
               @JsonProperty("bio") String bio,
               @JsonProperty("location") String location,
               @JsonProperty("available") boolean available) {
        this.owner = owner;
        this.email = email;
        this.phoneNum = phoneNum;
        this.petID = petID;
        this.species = species;
        this.petAge = petAge;
        this.breed = breed;
        this.personality = personality;
        this.bio = bio;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.location = location;
        this.isAvailable = available;
    }

    /**
     * Returns the name of the pet's owner.
     *
     * @return the owner's name
     */
    public String getOwner(){
        return owner;
    }

    /**
     * Returns the email address of the pet's owner.
     *
     * @return the owner's email address
     */
    public String getEmail(){
        return email;
    }

    /**
     * Returns the phone number of the pet's owner.
     *
     * @return the owner's phone number
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**
     * Returns the unique identifier of the pet.
     *
     * @return the pet ID
     */
    public int getPetID(){
        return petID;
    }

    /**
     * Returns the species of the pet.
     *
     * @return the pet's species
     */
    public String getSpecies(){
        return species;
    }

    /**
     * Returns the breed of the pet.
     *
     * @return the pet's breed
     */
    public String getBreed(){
        return breed;
    }

    /**
     * Returns the list of personality traits of the pet.
     *
     * @return a list of the pet's personality traits
     */
    public List<String> getPersonality(){
        return personality;
    }

    /**
     * Returns the biography of the pet.
     *
     * @return the pet's biography
     */
    public String getBio(){
        return bio;
    }

    /**
     * Returns the gender of the pet.
     *
     * @return the pet's gender
     */
    public String getGender(){
        return gender;
    }

    /**
     * Returns the age of the pet.
     *
     * @return the pet's age
     */
    public int getPetAge(){
        return petAge;
    }

    /**
     * Returns the activity level of the pet.
     *
     * @return the pet's activity level
     */
    public String getActivityLevel(){
        return this.activityLevel;
    }

    /**
     * Returns the location of the pet.
     *
     * @return the pet's location
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Returns whether the pet is available for adoption.
     *
     * @return {@code true} if the pet is available, {@code false} otherwise
     */
    public boolean isAvailable(){
        return isAvailable;
    }

    /**
     * Marks the pet as unavailable for adoption.
     */
    public void markUnavailable(){
        this.isAvailable = false;
    }

    /**
     * Returns a string representation of the pet's details.
     *
     * @return a string containing all relevant details of the pet
     */
    @Override
    public String toString() {
        return "Pet [owner=" + owner + ", email=" + email + ", phoneNum=" + phoneNum + ", petAge=" + petAge +
                ", breed=" + breed + ", personality=" + personality + ", species=" + species + ", bio=" + bio +
                ", activity level=" + activityLevel + ", gender" + gender + ", location=" + location + ", isAvailable=" + isAvailable + "]";

    }
}
