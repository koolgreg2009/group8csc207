package entity;

import java.util.List;

public interface UserPreferenceInt {

    void setSpecies(String species);
    String getSpecies();

    void setBreeds(ArrayList<> breeds);
    List<> getBreeds();

    void setMinAge(int min);
    int getMinAge();

    void setMaxAge(int max);
    int getMaxAge();

    void setActivityLevel(String level);
    String getActivityLevel();
}
