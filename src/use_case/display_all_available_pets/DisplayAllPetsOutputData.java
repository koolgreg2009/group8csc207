package use_case.display_all_available_pets;

import java.util.List;
import entity.Pet;

public class DisplayAllPetsOutputData {
    private final List<Pet> pets;

    public DisplayAllPetsOutputData(List<Pet> pets) {
        this.pets = pets;
    }
    public List<Pet> getPets() {
        return pets;
    }
}
