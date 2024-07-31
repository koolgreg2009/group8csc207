package use_case.preference;

/**
 * This interface defines the contract for presenting user preferences.
 *
 * <p>Implementations of this interface will handle the logic required to present the user preferences
 * based on the provided output data.
 */
public interface PreferenceOutputBoundary {

    /**
     * Prepares and presents the user preferences based on the output data.
     *
     * @param preferenceOutputData the data containing the user preferences to be presented
     */
    void preparePreferenceView(PreferenceOutputData user);
}
