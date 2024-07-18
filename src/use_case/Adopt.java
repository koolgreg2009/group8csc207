package use_case;
import data_access.UserDAOInterface;

public class Adopt implements AdoptInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final AdoptOutputBoundary userPresenter;

    public Adopt(UserDAOInterface userDataAccessObject, AdoptOutputBoundary userPresenter){
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
    }


    @Override
    public void execute(Adopt adopt) {
        if (userDataAccessObject.existsByName(AdoptInputData.getPet())) {
            userPresenter.prepareAdopt("Pet has found a home");
    }
}

