package interface_adapter.get_breed;

import use_case.get_breed_info.GetBreedOutputData;

public class GetBreedPresenter {
    public void prepareGetBreedView(GetBreedOutputData getBreedOutputData){
        System.out.println(getBreedOutputData.getBreedJson());
    }
}
