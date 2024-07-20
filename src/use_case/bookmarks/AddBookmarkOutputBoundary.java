package use_case.bookmarks;

public interface AddBookmarkOutputBoundary {
    void prepareSuccessView(AddBookmarkOutputData outputdata);
    void prepareErrorView(String errormsg);
}
