package interface_adapter.adopt;

import use_case.adopt.AdoptOutputBoundary;
import use_case.adopt.AdoptOutputData;

/** Adopt presenter class to present the message
 */
public class AdoptPresenter implements AdoptOutputBoundary {

    /** method thats called when pet is adopted.
     */
    @Override
    public void prepareAdopt(AdoptOutputData adoptoutdata){
        System.out.println(adoptoutdata.getPetOwner() + " has adopt " + adoptoutdata.getPetID());
    }
}
