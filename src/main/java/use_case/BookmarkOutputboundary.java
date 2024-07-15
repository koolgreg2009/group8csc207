package use_case;

public interface BookmarkOutputboundary {
    public void prepareSuccessView(BookmarkOutputdata outputdata);
    public void prepareErrorView(String errormsg);
}
