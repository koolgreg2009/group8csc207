package entity;

import java.util.ArrayList;
import java.util.List;

/** This Pet class contains all the information associated with a pet.
 *
 * @version 1.0
 * @since 2024-07-16
 */

public class Pet{
    private String owner;
    private String email;
    private String phoneNum;
    private int petID;
    private String species;
    private int age;
    private String breed;
    private List<String> personality = new ArrayList<>();
    private String bio;
    private int activityLevel;
    private String gender;
    private String location;
    private boolean isAvailable;

    /** Pet class constructor
     * @param owner
     * @param email
     * @param phoneNum
     * @param petID
     * @param species
     * @param age
     * @param breed
     * @param personality
     * @param bio
     * @param gender
     */
    public Pet(String owner, String email, String phoneNum, int petID, String species, int age,
               String breed, List<String> personality, String gender, int activityLevel, String bio){
        this.owner = owner;
        this.email = email;
        this.phoneNum = phoneNum;
        this.petID = petID;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.personality = personality;
        this.bio = bio;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.isAvailable = true;
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
    public int getPetAge(){
        return age;
    }

    /** Increases the age of the pet by 1 every year as the pet gets older
     */
    public void petGetsOlder(){
        age +=1;
    }

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
    public void addPetDetails(String trait){
        personality.add(trait);
    }

    /** Gets the pet's biography
     * @return A String of the pet's biography
     */
    public String getBio(){
        return bio;
    }

    /** Adds to the pet's biography
     */
    public void setBio(String newBio){
        this.bio = newBio;
    }

    /** Gets the pet's gender
     * @return A String of the pet's gender
     */
    public String getGender(){
        return gender;
    }


    public void adopt(){
        this.isAvailable = false;
        // more to be added
    }
    public int getAge(){
        return age;
    }

    public int getActivityLevel(){
        return this.activityLevel;
    }

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
}
