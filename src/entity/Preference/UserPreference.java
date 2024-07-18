package entity.Preference;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/** This UserPreference class contains all the preferences that the user can select
 * to filter the kinds of adoption postings they want to see.
 *
 * @version 1.0
 * @since 2024-07-16
 *
 */

public class UserPreference{

	private String species;
	private List<String> breeds;
	private int minAge;
	private int maxAge;
	private String activityLevel;
	private String location;
	private String gender;

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
