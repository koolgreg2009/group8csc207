package use_case.bookmarks;

public interface AddBookmarkOutputBoundary {
    void prepareSuccessView(BookmarkOutputData outputdata);
    void prepareErrorView(String errormsg);
}
