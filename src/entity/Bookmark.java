package entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** This Bookmark class contains bookmarks that adopter user made to save pets they are
 * interested in adopting. Bookmarks are created with the pet ID and the time that
 * the bookmark is created.
 *
 * @version 2.0
 * @since 2024-07-16
 */
public class Bookmark {
	private int petID;
	private LocalDateTime bookmarkedDate;

	/** Initializer for a bookmark.
	 * @param petID the pet in the listing being bookmarked.
	 * @param time       the date and time the bookmark is created.
	 */
	@JsonCreator()
	public Bookmark(@JsonProperty("petID") int petID, @JsonProperty("time") LocalDateTime time) {

		this.petID = petID;
		this.bookmarkedDate = time;
	}

	/** Getter method for ID of pet.
	 * @return int petID
	 */
	public int getPetID() {
		return petID;
	}

	/** Getter method for date and time of bookmark.
	 * @return LocalDateTime of date and time of bookmark.
	 */
	public LocalDateTime getBookmarkedDate() {
		return bookmarkedDate;
	}
}