package use_case.preference;

/** The PreferenceInputBoundary interface is the input boundary for the preference use case.
 * It contains the abstract methods that will be implemented by the InitialPreferenceInteractor class
 * and EditPreferenceInteractor class.
 *
 * @version 1.0
 * @since 2024-07-18
 */

public interface PreferenceInputBoundary {

    /** This execute method is an abstract that will be implemented by EditPreferenceInteractor
     * class and InitialPreferenceInteractor class.
     * @param initialPreferenceData
     */
    void execute(PreferenceData initialPreferenceData);
}
