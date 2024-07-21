package use_case.preference;

/** The PreferenceInputBoundary interface is the input boundary for the preference use case.
 * It contains the abstract methods that will be implemented by the PreferenceInteractor class
 *
 * @version 1.0
 * @since 2024-07-18
 */

public interface PreferenceInputBoundary {

    /** This execute method is an abstract that will be implemented by PreferenceInteractor class
     *
     * @param preferenceData the preference data being input
     */
    void execute(PreferenceData preferenceData);
}
