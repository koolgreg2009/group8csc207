package use_case.display;

import java.util.List;

import dto.pet.PetDTO;

/**
 * Encapsulates the output data required to display all pets.
 * <p>
 * This class stores a list of pets and provides a method to access this list.
 */
public class DisplayPetsOutputData {
    private final List<PetDTO> pets;

    /**
     * Constructs a {@code DisplayAllPetsOutputData} object with the specified list of pets.
     *
     * @param pets the list of pets to be displayed
     */
    public DisplayPetsOutputData(List<PetDTO> pets) {
        this.pets = pets;
    }

    /**
     * Returns the list of pets to be displayed.
     *
     * @return the list of pets
     */
    public List<PetDTO> getPets() {
        return pets;
    }
}
