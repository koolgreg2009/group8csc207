package interface_adapter.get_breed;

import use_case.get_breed_info.getBreedOutputData;

public class GetBreedPresenter {
    public void prepareGetBreedView(getBreedOutputData getBreedOutputData){
        System.out.println(getBreedOutputData.getBreedJson());
    }
}
