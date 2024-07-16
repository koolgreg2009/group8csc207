package entity.Preference;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPreference{

	private String species;
	private List<String> breeds;
	private int minAge;
	private int maxAge;
	private String activityLevel;
	private String location;

	/** Sets the preferred species of the user
	 * @param species A string of the preferred species
	 */
	@JsonProperty("species")
	public void setSpecies(String species) {
		this.species = species;
	}

	/** Gets the preferred species of the user
	 * @return A string of the preferred species
	 */
	@JsonProperty("species")
	public String getSpecies() {
		return this.species;
	}

	/** Sets the preferred breeds of the user
	 * @param breeds A list of strings of the preferred breeds
	 */
	@JsonProperty("breeds")
	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

	/** Gets the preferred breeds of the user
	 * @return A list of strings of the preferred breeds
	 */
	@JsonProperty("breeds")
	public List<String> getBreeds() {
		return this.breeds;
	}

	/** Sets the preferred minimum age of pet
	 * @param min An integer of the preferred minimum age
	 */
	@JsonProperty("minAge")
	public void setMinAge(int min) {
		this.minAge = min;
	}

	/** Gets the preferred minimum age of pet
	 * @return An integer of the preferred minimum age
	 */
	@JsonProperty("minAge")
	public int getMinAge() {
		return this.minAge;
	}

	/** Sets the preferred maximum age of pet
	 * @param max An integer of the preferred maximum age
	 */
	@JsonProperty("maxAge")
	public void setMaxAge(int max) {
		this.maxAge = max;
	}

	/** Gets the preferred maximum age of pet
	 * @return An integer of the preferred maximum age
	 */
	@JsonProperty("maxAge")
	public int getMaxAge() {
		return this.maxAge;
	}

	/** Sets the preferred activity level of the pet
	 * @param level A string of the preferred activity level
	 */
	@JsonProperty("activityLevel")
	public void setActivityLevel(String level) {
		this.activityLevel = level;
	}

	/** Gets the preferred activity level of the pet
	 * @return A string of the preferred activity level
	 */
	@JsonProperty("activityLevel")
	public String getActivityLevel() {
		return this.activityLevel;
	}

	/** Sets the preferred location for where to adopt the pet
	 * @param location A string of the preferred location
	 */
	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	/** Gets the preferred location for where to adopt the pet
	 * @return A string of the preferred location
	 */
	@JsonProperty("location")
	public String getLocation(String location) {
		return this.location;
	}
}
