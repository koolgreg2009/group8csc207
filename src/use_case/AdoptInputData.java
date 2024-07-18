package use_case;

import entity.Pet;
import entity.User.User;

import java.util.List;

/** Getting data for Adopt
 */
public class AdoptInputData {
    private List<User> bookmarkList;
    private Pet pet;

    public AdoptInputData(List<User> bookmarkList, Pet pet) {
        this.bookmarkList = bookmarkList;
        this.pet = pet;
    }
    public List<User> getBookmarkList() {
        return bookmarkList;
    }
    public int getPetID(){
        return pet.getPetID();
    }
}
