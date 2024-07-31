package entity.preference;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the user preferences for selecting pets.
 *
 * <p>This class encapsulates various preferences that a user may have for choosing a pet, including
 * species, breeds, age range, activity level, location, and gender.
 */

public class UserPreference{

	private String species;
	private List<String> breeds;
	private int minAge;
	private int maxAge;
	private String activityLevel;
	private String location;
	private String gender;

	/**
	 * Constructs an empty {@code UserPreference} object.
	 * <p>This constructor allows for the creation of a {@code UserPreference} object
	 * without initializing any fields. Fields can be set using setter methods.
	 */
	public UserPreference(){
	}

	/**
	 * Constructs a {@code UserPreference} object with the specified preferences.
	 *
	 * @param species the preferred species of the pet
	 * @param breeds the preferred breeds of the pet
	 * @param minAge the minimum age of the pet
	 * @param maxAge the maximum age of the pet
	 * @param activityLevel the preferred activity level of the pet
	 * @param location the preferred location of the pet
	 * @param gender the preferred gender of the pet
	 */
	public UserPreference(String species, List<String> breeds, int minAge, int maxAge, String activityLevel, String location, String gender){
		this.species = species;
		this.breeds = breeds;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.activityLevel = activityLevel;
		this.location = location;
		this.gender = gender;
	}
	/** Sets the user's preferred species
	 * @param species A string of the user's preferred species
	 */
	@JsonProperty("species")
	public void setSpecies(String species) {
		this.species = species;
	}

	/** Gets the user's preferred species
	 * @return A string of the user's preferred species
	 */
	@JsonProperty("species")
	public String getSpecies() {
		return this.species;
	}

	/** Sets the user's preferred breeds
	 * @param breeds A list of strings of the user's preferred breeds
	 */
	@JsonProperty("breeds")
	public void setBreeds(List<String> breeds) {
		this.breeds = breeds;
	}

	/** Gets the user's preferred breeds
	 * @return A list of strings of the user's preferred breeds
	 */
	@JsonProperty("breeds")
	public List<String> getBreeds() {
		return this.breeds;
	}

	/** Sets the user's preferred minimum age of pet
	 * @param min An integer of the user's preferred minimum pet age
	 */
	@JsonProperty("minAge")
	public void setMinAge(int min) {
		this.minAge = min;
	}

	/** Gets the user's preferred minimum age of pet
	 * @return An integer of the user's preferred minimum pet age
	 */
	@JsonProperty("minAge")
	public int getMinAge() {
		return this.minAge;
	}

	/** Sets the user's preferred maximum pet age
	 * @param max An integer of the user's preferred maximum pet age
	 */
	@JsonProperty("maxAge")
	public void setMaxAge(int max) {
		this.maxAge = max;
	}

	/** Gets the user's preferred maximum pet age
	 * @return An integer of the user's preferred maximum pet age
	 */
	@JsonProperty("maxAge")
	public int getMaxAge() {
		return this.maxAge;
	}

	/** Sets the user's preferred pet activity level
	 * @param level A string of the user's preferred pet activity level
	 */
	@JsonProperty("activityLevel")
	public void setActivityLevel(String level) {
		this.activityLevel = level;
	}

	/** Gets the user's preferred pet activity level
	 * @return A string of the user's preferred pet activity level
	 */
	@JsonProperty("activityLevel")
	public String getActivityLevel() {
		return this.activityLevel;
	}

	/** Sets the user's preferred location for pet adoption
	 * @param location A string of the user's preferred location for pet adoption
	 */
	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	/** Gets the user's preferred location for pet adoption
	 * @return A string of the user's preferred location for pet adoption
	 */
	@JsonProperty("location")
	public String getLocation() {
		return this.location;
	}

	/** Sets the user's preferred pet gender
	 * @param gender A string of the user's preferred pet gender
	 */
	@JsonProperty("gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	/** Gets the user's preferred pet gender
	 * @return A string of the user's preferred pet gender
	 */
	@JsonProperty("gender")
	public String getGender() {
		return this.gender;
	}
}
