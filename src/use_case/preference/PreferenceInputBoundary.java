package use_case.preference;

/**
 * The {@code PreferenceInputBoundary} interface defines the input boundary for the preference use case.
 * It declares the methods that must be implemented by the {@code PreferenceInteractor} class.
 */
public interface PreferenceInputBoundary {

    /**
     * Executes the preference use case with the provided {@code PreferenceData}.
     *
     * @param preferenceData the preference data to be processed by the use case.
     */
    void execute(PreferenceData preferenceData);
}
