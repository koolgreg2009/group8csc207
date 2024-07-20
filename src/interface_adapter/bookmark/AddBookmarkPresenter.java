package interface_adapter.bookmark;

import use_case.bookmarks.AddBookmarkOutputBoundary;
import use_case.bookmarks.BookmarkOutputData;

public class AddBookmarkPresenter implements AddBookmarkOutputBoundary {

    public void prepareSuccessView(BookmarkOutputData outputData){
        System.out.println(outputData.getBookmark()+" has been removed. New bookmarks: "+ outputData.getBookmark());
    }
    public void prepareErrorView(String errormsg){
        System.out.println(errormsg);
    }
}
