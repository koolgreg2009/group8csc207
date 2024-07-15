package use_case;
import entity.Pet;
import entity.Bookmark;

import java.util.List;

public class Adopt {
    private Pet pet;
    private List<Bookmark> bookmarkList;

    public Adopt(Pet pet, List<Bookmark> bookmarkList){
        this.pet = pet;
        this.bookmarkList = bookmarkList;
    }

    public String removeBookmark(){
        for(int i = 0 ; i < bookmarkList.size(); i++){
            if (bookmarkList.contains(pet)){
                bookmarkList.remove(pet);
            }
        }
        return "This pet has been adopted";
    }
}
