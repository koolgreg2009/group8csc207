package entity.Preference;

import java.util.List;

public class UserPreference{

	private String species;
	private List<String> breeds;
	private int minAge;
	private int maxAge;
	private String activityLevel;
	private String location;

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

	public List<String> getBreeds() {
		return this.breeds;
	}

	public void setMinAge(int min) {
		this.minAge = min;
	}

	public int getMinAge() {
		return this.minAge;
	}

	public void setMaxAge(int max) {
		this.maxAge = max;
	}

	public int getMaxAge() {
		return this.maxAge;
	}

	public void setActivityLevel(String level) {
		this.activityLevel = level;
	}

	public String getActivityLevel() {
		return this.activityLevel;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation(String location) {
		return this.location;
	}
}
