package use_case;
import entity.Pet;
import entity.Bookmark;

import java.util.List;

public class Adopt implements AdoptBoundary{
    private Pet pet;
    private List<Bookmark> bookmarkList;

    public Adopt(Pet pet, List<Bookmark> bookmarkList){
        this.pet = pet;
        this.bookmarkList = bookmarkList;
    }


    @Override
    public void execute(Adopt adopt) {
        for (int i = 0; i < bookmarkList.size(); i++) {
            if (bookmarkList.contains(pet)) {
                bookmarkList.remove(pet);
            }
        }
    }
}
