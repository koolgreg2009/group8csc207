package interface_adapter.get_breed;

import use_case.get_breed_info.GetBreedOutputBoundary;
import use_case.get_breed_info.GetBreedOutputData;

public class GetBreedPresenter implements GetBreedOutputBoundary {
    public void prepareGetBreedView(GetBreedOutputData getBreedOutputData){
        System.out.println(getBreedOutputData.getBreedJson());
    }
}
