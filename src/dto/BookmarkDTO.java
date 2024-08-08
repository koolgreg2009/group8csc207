package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing a bookmarked pet.
 */
public class BookmarkDTO {
    private final PetDTO pet;
    private final LocalDateTime bookmarkedDate;

    /**
     * Constructs a new BookmarkDTO with the specified pet ID and bookmarked date.
     *
     * @param pet           the pet that is bookmarked
     * @param bookmarkedDate  the date and time when the pet was bookmarked
     */
    public BookmarkDTO(PetDTO pet, LocalDateTime bookmarkedDate) {
        this.pet = pet;
        this.bookmarkedDate = bookmarkedDate;
    }

    /**
     * Returns the ID of the bookmarked Pet
     *
     * @return the ID of the bookmarked Pet.
     */
    public int getPetID() {
        return pet.getPetID();
    }

    /**
     * Returns the bookmarked Pet
     *
     * @return the bookmarked pet
     */
    public PetDTO getPet() {
        return pet;
    }

    /**
     * Returns the date and time when the pet was bookmarked.
     *
     * @return the bookmarked date and time
     */
    public LocalDateTime getBookmarkedDate() {
        return bookmarkedDate;
    }

}
