package view;

/**
 * The {@code PetActionView} interface defines the actions that can be performed on a pet within the view.
 * <p>
 * It provides methods for adding, viewing details, adopting, and removing pets.
 */
public interface PetActionView {

	/**
	 * Adds a pet with the specified ID to the user's list of bookmarks or favorites.
	 *
	 * @param petID the unique identifier of the pet to be added.
	 */
	void add(int petID);

	/**
	 * Opens the detailed view of the pet with the specified ID.
	 *
	 * @param petID the unique identifier of the pet to be viewed.
	 */
	void goDetail(int petID);

	/**
	 * Initiates the adoption process for the pet with the specified ID.
	 *
	 * @param petID the unique identifier of the pet to be adopted.
	 */
	void adopt(int petID);

	/**
	 * Removes the pet with the specified ID from the user's list of bookmarks or favorites.
	 *
	 * @param petID the unique identifier of the pet to be removed.
	 */
	void remove(int petID);
}
