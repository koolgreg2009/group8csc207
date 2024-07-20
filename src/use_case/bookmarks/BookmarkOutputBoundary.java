package use_case.bookmarks;

public interface BookmarkOutputBoundary {
    public void prepareSuccessView(BookmarkOutputData outputdata);
    public void prepareErrorView(String errormsg);
}
