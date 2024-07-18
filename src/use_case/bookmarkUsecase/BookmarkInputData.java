package use_case.bookmarkUsecase;

import entity.Pet;

//public class BookmarkInputData {
//    public class AddBookmarkInputData {
//        private int userId;
//        private int petId;
//
//        public AddBookmarkInputData(int userId, int petId) {
//            this.userId = userId;
//            this.petId = petId;
//        }
//
//        public int getUserID(){
//            return this.userId;
//        }
//        public int getPetID(){
//            return this.petId;
//        }
//
//    }
//    public class RemoveBookmarkInputData {
//        private int userId;
//        private int petId;
//
//        public RemoveBookmarkInputData(int userId, int petId) {
//            this.userId = userId;
//            this.petId = petId;
//        }
//
//        // Getters and setters
//    }
//
//}
public class BookmarkInputData {
    private final String username;
    private final int petID;

    public BookmarkInputData(String username, int petID) {
        this.username = username;
        this.petID = petID;
    }
    public String getUserID() {
        return this.username;
    }

    public int getPetID(){
        return petID;
    }
}