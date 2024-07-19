package use_case.bookmarks;

import use_case.signup.SignupOutputData;

public interface RemoveBookmarkOutputBoundary {
    void prepareSuccessView(SignupOutputData signupOutputData);
}
