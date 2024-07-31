package use_case.display.display_all_available_pets;


public class DisplayAllPetsInputData {
    private final String user;

    public DisplayAllPetsInputData(String user){
        this.user = user;
    }

    public String getUser(){
        return this.user;
    }
}
