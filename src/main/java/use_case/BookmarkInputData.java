package use_case;

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
    private int userID;
    private int petID;

    public BookmarkInputData(int userID, int petID) {
        this.userID = userID;
        this.petID = petID;
    }
    public int getUserID() {
        return userID;
    }

    public int getpetID(){
        return petID;
    }
}