package entity;

import java.util.ArrayList;
import java.util.List;
/** Represents a pet.
 * @author uwuowouwuowouwuowouwuowo
 */
public class Pet{
    private int petID;
    private String species;
    private int age;
    private String breed;
    private List<String> personality = new ArrayList<>();
    private String bio;
    private boolean isAvailable;
    // add owner name, email, phone number, and getters and setters for each.

    /** Pet class constructor
     * @param petID
     * @param species
     * @param age
     * @param breed
     * @param personality
     * @param bio
     */
    public Pet(int petID, String species, int age, String breed, List<String> personality, String bio){
        this.petID = petID;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.personality = personality;
        this.bio = bio;
        this.isAvailable = true;
    }
    /**Gets the species of the pet
     * @return A string of the species of the pet
     */
    public String getSpecies(){
        return species;
    }
    /**Gets the age of the pet
     * @return An int of the pets's age
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
     * @return A String of the pets's breed
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
     * @return A String of the pets's biography
     */
    public String getBio(){
        return bio;
    }

    /** Adds to the pet's bio
     */
    public void setBio(String newBio){
        this.bio = newBio;
    }

    /**Set pet unavailable
     */
    public void markUnavailable(){
        this.isAvailable = false;
    }

}
