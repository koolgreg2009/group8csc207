package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/** This Pet class contains all the information associated with a pet.
 *
 * @version 1.0
 * @since 2024-07-16
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
    /** Gets the pet owner's name
     * @return A string of the owner's name
     */
    public String getOwner(){
        return owner;
    }

    /** Gets the pet owner's email
     * @return A string of the pet owner's email
     */
    public String getEmail(){
        return email;
    }

    /** Gets the owner's phone number
     * @return A string of the owner's phone number
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /** Gets the ID of the pet
     * @return A string of the ID of the pet
     */
    public int getPetID(){
        return petID;
    }
  
    /** Gets the pet's species
     * @return A string of pet's species
     */
    public String getSpecies(){
        return species;
    }

    /** Gets the pet's age
     * @return An int of the pet's age
     */

    /** Increases the age of the pet by 1 every year as the pet gets older
     */

    /** Gets the pet's breed
     * @return A String of the pet's breed
     */
    public String getBreed(){
        return breed;
    }

    /** Gets the pet's personality
     * @return A list of the pet's personality(s)
     */
    public List<String> getPersonality(){
        return personality;
    }

    /** Adds to the pet's personality
     */

    public String getBio(){
        return bio;
    }

    /** Adds to the pet's biography
     */

    public String getGender(){
        return gender;
    }


    /** Gets the pet's age
     * @return An Int of the pet's age
     */
    public int getPetAge(){
        return petAge;
    }

    /** Gets the pet's activity level
     * @return A String of the pet's activity
     */
    public String getActivityLevel(){
        return this.activityLevel;
    }

    /** Gets the pet's location
     * @return A String of the pet's location
     */
    public String getLocation(){
        return this.location;
    }
  
    /** Gets the availability of the pet
     * @return A boolean to indicate availability of pet
     */
    public boolean isAvailable(){
        return isAvailable;
    }

    /** Set pet to be unavailable
     */
    public void markUnavailable(){
        this.isAvailable = false;
    }

    /** for simple console print phase 1 */
    @Override
    public String toString() {
        return "Pet [owner=" + owner + ", email=" + email + ", phoneNum=" + phoneNum + ", petAge=" + petAge +
                ", breed=" + breed + ", personality=" + personality + ", species=" + species + ", bio=" + bio +
                ", activity level=" + activityLevel + ", gender" + gender + ", location=" + location + ", isAvailable=" + isAvailable + "]";

    }
}
