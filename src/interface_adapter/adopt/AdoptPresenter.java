package interface_adapter.adopt;

import interface_adapter.SessionManager;
import use_case.adopt.AdoptOutputBoundary;
import use_case.adopt.AdoptOutputData;

/** Adopt presenter class to present the message
 */
public class AdoptPresenter implements AdoptOutputBoundary {

    /** method thats called when pet is adopted.
     */
    @Override
    public void prepareAdopt(AdoptOutputData adoptoutdata){
        System.out.println("Thank  you "+ SessionManager.getCurrentUser()+" for adopting Pet: "+adoptoutdata.getID()+"\n" +
                "You may contact the owner "+adoptoutdata.getPetOwner() +" through: \n             " + adoptoutdata.getOwnerEmail() +" and "+ adoptoutdata.getOwnerPhone());
    }
}
