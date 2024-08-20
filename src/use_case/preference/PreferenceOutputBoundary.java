package use_case.preference;

/**
 * The {@code PreferenceOutputBoundary} interface defines the contract for presenting user preferences.
 * <p>
 * Implementations of this interface handle the logic required to present the user preferences based on the
 * provided output data, including success and failure scenarios.
 */
public interface PreferenceOutputBoundary {

    /**
     * Prepares and presents the user preferences successfully.
     */
    void prepareSuccessView();

    /**
     * Prepares and presents a failure view when the breed preference is invalid.
     */
    void prepareBreedFail();

    /**
     * Prepares and presents a failure view when the location preference is invalid.
     */
    void prepareLocationFail();
}
