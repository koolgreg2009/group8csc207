package use_case.display;

import java.util.List;
import entity.Pet;

public class DisplayPetsOutputData {
    private final List<Pet> pets;

    public DisplayPetsOutputData(List<Pet> pets) {
        this.pets = pets;
    }
    public List<Pet> getPets() {
        return pets;
    }
}
