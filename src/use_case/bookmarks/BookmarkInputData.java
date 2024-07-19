package use_case.bookmarks;

public class BookmarkInputData {
    private final String username;
    private final int petID;

    public BookmarkInputData(String username, int petID) {
        this.username = username;
        this.petID = petID;
    }
    public String getUsername() {
        return this.username;
    }

    public int getPetID(){
        return petID;
    }
}