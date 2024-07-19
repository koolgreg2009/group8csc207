package use_case.bookmarks;

public interface BookmarkOutputboundary {
    public void prepareSuccessView(BookmarkOutputdata outputdata);
    public void prepareErrorView(String errormsg);
}
