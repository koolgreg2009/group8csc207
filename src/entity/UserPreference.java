package entity;

import java.util.ArrayList;
import java.util.List;

public class UserPreference implements UserPreferenceInt{

    private String species;
    private ArrayList<String> breeds;
    private int minAge;
    private int maxAge;
    private String activityLevel;

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String getSpecies() {
        return this.species;
    }

    @Override
    public void setBreeds(ArrayList<String> breeds) {
        this.breeds = breeds;
    }

    @Override
    public ArrayList<String> getBreeds() {
        return this.breeds;
    }

    @Override
    public void setMinAge(int min) {
        this.minAge = min;
    }

    @Override
    public int getMinAge() {
        return this.minAge;
    }

    @Override
    public void setMaxAge(int max) {
        this.maxAge = max;
    }

    @Override
    public int getMaxAge() {
        return this.maxAge;
    }

    @Override
    public void setActivityLevel(String level) {
        this.activityLevel = level;
    }

    @Override
    public String getActivityLevel() {
        return this.activityLevel;
    }
}
