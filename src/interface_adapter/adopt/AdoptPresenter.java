package interface_adapter.adopt;

import use_case.adopt.AdoptOutputBoundary;
import use_case.adopt.AdoptOutputData;

public class AdoptPresenter implements AdoptOutputBoundary {

    @Override
    public void prepareAdopt(AdoptOutputData adoptoutdata){
        System.out.println(adoptoutdata.getPetOwner() + " has adopt " + adoptoutdata.getPetID());
    }
}
