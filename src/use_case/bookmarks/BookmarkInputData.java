package use_case.bookmarks;

import entity.Pet;

/** The BookmarkInputData class bundles user input data for bookmarking.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class BookmarkInputData {
    private final String username;
    private final int petID;

    /** This is the constructor for the BookmarkInputData class.
     * @param username The username of the adopter user.
     * @param petID The ID of the pet.
     */
    public BookmarkInputData(String username, int petID) {
        this.username = username;
        this.petID = petID;
    }

    /** Gets the username of the adopter user.
     * @return a String of the user's username.
     */
    public String getUsername() {
        return this.username;
    }

    /** Gets the ID of the pet.
     * @return the pet ID as an int.
     */
    public int getPetID(){
        return petID;
    }
}