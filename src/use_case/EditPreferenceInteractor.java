package use_case;

import data_access.FileUserDAO;
import use_case.PreferenceUseCase.InitialPreferenceData;

public class EditPreferenceInteractor implements PreferenceInputBoundary{

    @Override
    public void execute(InitialPreferenceData initialPreferenceData){
        //Implement this
        //Retrieve the user from the JSON File THROUGH DAO
        //Then take the information from InitialPreferenceData and update the user java object
        //Send updated user back to the DAO
        //Then make an output data object (PreferenceOutputData) to send to presenter by evoking the presenter

    }
}
