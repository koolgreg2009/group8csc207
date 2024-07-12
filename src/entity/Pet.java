package entity;

import java.util.ArrayList;
import java.util.List;

/** Represents a pet.
 * @author uwuowouwuowouwuowouwuowo
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
     // add owner name, email, phone number, and getters and setters for each.
     */
    public Pet(String owner, String email, String phoneNum, int petID, String species, int age, String breed, List<String> personality, String bio){
        this.owner = owner;
        this.email = email;
        this.phoneNum = phoneNum;
        this.petID = petID;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.personality = personality;
        this.bio = bio;
        this.isAvailable = true;
    }
    /**Gets the owner of the pet
     * @return A string of the species of the pet
     */
    public String getOwner(){
        return owner;
    }
    /**Gets the email of the pet owner
     * @return A string of the species of the pet
     */
    public String getEmail(){
        return email;
    }
    /**Gets the phone number of the pet owner
     * @return A string of the species of the pet
     */
    public String getPhoneNum(){
        return phoneNum;
    }

    /**Gets the ID of the pet
     * @return A string of the species of the pet
     */
    public int getPetID(){
        return petID;
    }
  
    /**Gets the species of the pet
     * @return A string of the species of the pet
     */
    public String getSpecies(){
        return species;
    }
    /**Gets the age of the pet
     * @return An int of the pet's age
     */
    public int getPetAge(){
        return age;
    }

    /** Adds one to the pet's age after a year
     */
    public void petGetsOlder(){
        age +=1;
    }

    /**Gets the breed of the pet
     * @return A String of the pet's breed
     */
    public String getBreed(){
        return breed;
    }

    /**Gets the personality of the pet
     * @return A list of the pets's personality(s)
     */
    public List<String> getPersonality(){
        return personality;
    }

    /** Adds to the pet's personality
     */
    public void addPetDetails(String trait){
        personality.add(trait);
    }

    /**Gets the bio of the pet
     * @return A String of the pet's biography
     */
    public String getBio(){
        return bio;
    }

    /** Adds to the pet's bio
     */
    public void setBio(String newBio){
        this.bio = newBio;
    }

    
    public void adopt(){
        this.isAvailable = false;
        // more to be added
    }
  
    /**Gets the availability of the pet
     * @return A boolean to indicate availability of pet
     */
    public boolean isAvailable(){
        return isAvailable;
    }

    /**Set pet unavailable
     */
    public void markUnavailable(){
        this.isAvailable = false;
    }
}
