package use_case.display;

import java.util.List;
import entity.Pet;

/**
 * Encapsulates the output data required to display all pets.
 * <p>
 * This class stores a list of pets and provides a method to access this list.
 */
public class DisplayPetsOutputData {
    private final List<Pet> pets;

    /**
     * Constructs a {@code DisplayAllPetsOutputData} object with the specified list of pets.
     *
     * @param pets the list of pets to be displayed
     */
    public DisplayPetsOutputData(List<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Returns the list of pets to be displayed.
     *
     * @return the list of pets
     */
    public List<Pet> getPets() {
        return pets;
    }
}
