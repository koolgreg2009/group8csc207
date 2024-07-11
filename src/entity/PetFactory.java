package entity;

import java.util.ArrayList;

public class PetFactory {
    public Pet create(String owner, String email, String phoneNum, int petID, String species, int age, String breed, ArrayList personality, String bio, boolean isAvailable){return new Pet(owner, email, phoneNum, petID, species, age, breed, personality, bio, isAvailable);
    }
}
