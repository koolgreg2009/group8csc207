package interface_adapter.preference;

import entity.preference.UserPreference;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInputBoundary; // no PreferenceInputBoundary yet

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This is the Controller for the user's preference profile.
 *
 * @version 1.0
 * @since 2024-07-16
 */

public class PreferenceController {

    private final PreferenceInputBoundary preferenceInteractor; // ???

    /** This is the initializer for PreferenceController
     * @param preferenceInteractor The interactor
     */
    public PreferenceController(PreferenceInputBoundary preferenceInteractor) {
        this.preferenceInteractor = preferenceInteractor;
    }


    public void execute(String username){
        System.out.println("Executing set preference use case. If you have no preference for species, breeds, activity level, location and or gender, press enter without having anything typed in. For min and max age, enter 0.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter species: ");
        String species = scanner.nextLine();
        System.out.print("Enter breeds (comma-separated, no space in between): ");
        String breedsInput = scanner.nextLine();
        List<String> breeds = new ArrayList<>();
        for (String breed : breedsInput.split(",")) {
            breeds.add(breed.trim());
        }

        System.out.print("Enter minimum age: ");
        int minAge = scanner.nextInt();

        System.out.print("Enter maximum age: ");
        int maxAge = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter activity level: ");
        String activityLevel = scanner.nextLine();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        UserPreference preferences = new UserPreference(species, breeds, minAge, maxAge, activityLevel, location, gender);
        PreferenceData initialPreferences = new PreferenceData(username, preferences);
        preferenceInteractor.execute(initialPreferences);
    }
}
