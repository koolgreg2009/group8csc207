package entity;

import java.util.ArrayList;
import java.util.List;

public class PetFactory {
    public Pet create(String owner, String email, String phoneNum, int petID, String species, int age, String breed, List<String> personality, String bio, String gender, String activityLevel){
        return new Pet(owner, email, phoneNum, petID, species, age, breed, personality, gender, activityLevel, bio);
    }
    // need to create 2nd constructor that takes in bookmark and isabailable
}
