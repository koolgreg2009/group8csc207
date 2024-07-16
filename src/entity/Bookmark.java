package entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class containing bookmarks that adopter user made to save pets they are
 * interested in adopting.
 *
 * @version 1.0
 * @since 2024-07-14
 */
public class Bookmark {
	private int petID;
	private LocalDateTime bookmarkedDate;

	/**
	 * Initializer for a bookmark.
	 *
	 * @param petID the pet in the listing being bookmarked.
	 * @param time       the date and time the bookmark is created.
	 */
	@JsonCreator()
	public Bookmark(@JsonProperty("petID") int petID, @JsonProperty("time") LocalDateTime time) {

		this.petID = petID;
		this.bookmarkedDate = time;
	}

	/** Getter method for pet ID
	 * @return integer pet ID
	 */
	public int getPetID() {
		return petID;
	}

	/** Getter method for bookmark time and date
	 * @return LocalDateTime date and time of bookmark creation
	 */
	public LocalDateTime getBookmarkedDate() {
		return bookmarkedDate;
	}
}