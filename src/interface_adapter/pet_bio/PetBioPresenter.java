package interface_adapter.pet_bio;

import interface_adapter.ViewManagerModel;
import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;

/**
 * Presenter for handling and presenting pet biography information.
 * Implements the {@link PetBioOutputBoundary} interface to manage the presentation logic
 * for the pet bio use case and update the view model and view manager.
 */
public class PetBioPresenter implements PetBioOutputBoundary {

	private PetBioViewModel petBioViewModel;
	private ViewManagerModel viewManagerModel;

	/**
	 * Constructs a new {@code PetBioPresenter} with the specified view model and view manager.
	 *
	 * @param viewManagerModel the {@code ViewManagerModel} used for managing view transitions.
	 * @param petBioViewModel the {@code PetBioViewModel} used for updating pet bio information.
	 */
	public PetBioPresenter(ViewManagerModel viewManagerModel, PetBioViewModel petBioViewModel) {
		this.viewManagerModel = viewManagerModel;
		this.petBioViewModel = petBioViewModel;
	}

	/**
	 * Prepares and presents the pet biography information by updating the view model's state
	 * and setting the active view in the view manager.
	 *
	 * @param petBio the {@code PetBioOutputData} containing the pet biography information and user details.
	 */
	@Override
	public void preparePetBio(PetBioOutputData petBio) {
		petBioViewModel.getState().setPet(petBio.getPet());
		petBioViewModel.getState().setViewUser(petBio.getViewUser());
		petBioViewModel.firePropertyChanged();
		
		viewManagerModel.setActiveView(petBioViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}
}
