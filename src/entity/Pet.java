package entity;

import java.util.ArrayList;

public class Pet{
    private int petID;
    private String species;
    private int age;
    private String breed;
    private ArrayList personality;
    private String bio;
    private boolean isAvailable;

    public Pet(int petID, String species, int age, String breed, ArrayList personality, String bio, boolean isAvailable){
        this.petID = petID;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.personality = personality;
        this.bio = bio;
        this.isAvailable = true;
    }
    public String getSpecies(){
        return species;
    }

    public int getPetAge(){
        return age;
    }
    public void petGetsOlder(){
        age +=1;
    }
    public String getBreed(){
        return breed;
    }

    public ArrayList getPetDetails(){
        return personality;
    }

    public void addPetDetails(String trait){
        personality.add(trait);
    }

    public String getBio(){
        return bio;
    }

    public void setBio(String newBio){
        this.bio = newBio;
    }
    public void markUnavailable(){
        this.isAvailable = false;
    }

}
