package use_case;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;

public class Adopt implements AdoptInputBoundary {
    final PetDAOInterface petDAO;
    final AdoptOutputBoundary userPresenter;

    public Adopt(PetDAOInterface petDAO, AdoptOutputBoundary userPresenter){
        this.petDAO = petDAO;
        this.userPresenter = userPresenter;
    }

    @Override
    public void execute(AdoptInputData adoptInputData) {
        userPresenter.prepareAdopt("Pet has found a home");
        Pet uwu =  petDAO.get(adoptInputData.getPetID());
    }
}