package use_case.bookmarkUsecase;

public interface BookmarkOutputboundary {
    public void prepareSuccessView(BookmarkOutputdata outputdata);
    public void prepareErrorView(String errormsg);
}
