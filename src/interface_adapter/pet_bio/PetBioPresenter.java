package interface_adapter.pet_bio;

import interface_adapter.ViewManagerModel;
import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;

/**
 * Presenter for the pet bio information, it implements the output boundary for
 * the pet bio use case.
 */
public class PetBioPresenter implements PetBioOutputBoundary {

	private PetBioVIewModel petBioViewModel;
	private ViewManagerModel viewManagerModel;

	public PetBioPresenter(ViewManagerModel viewManagerModel, PetBioVIewModel petBioViewModel) {
		this.viewManagerModel = viewManagerModel;
		this.petBioViewModel = petBioViewModel;
	}

	/**
	 * Prepares and presents the pet bio info.
	 *
	 * @param petBio the data output that holds the pet bio information
	 */
	@Override
	public void preparePetBio(PetBioOutputData petBio) {
		// quote in front allows for petBio.getPet() to know it's a string, and calls
		// its toString method
		System.out.println(petBio.getPet());
		petBioViewModel.getState().setPet(petBio.getPet());
		petBioViewModel.getState().setViewUser(petBio.getViewUser());
		petBioViewModel.firePropertyChanged();
		
		viewManagerModel.setActiveView(petBioViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}
}
