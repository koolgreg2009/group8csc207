package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing a bookmarked pet.
 */
public class BookmarkDTO {
    private final List<PetDTO> pets;
    private final LocalDateTime bookmarkedDate;

    /**
     * Constructs a new BookmarkDTO with the specified pet ID and bookmarked date.
     *
     * @param pets           the pets that are bookmarked
     * @param bookmarkedDate  the date and time when the pet was bookmarked
     */
    public BookmarkDTO(List<PetDTO> pets, LocalDateTime bookmarkedDate) {
        this.pets = pets;
        this.bookmarkedDate = bookmarkedDate;
    }

    /**
     * Returns the ID of the pet.
     *
     * @return the pet ID
     */
    public List<PetDTO> getPets() {
        return pets;
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
