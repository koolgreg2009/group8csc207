package use_case;

import use_case.PreferenceUseCase.InitialPreferenceData;

public interface PreferenceInputBoundary {
    void execute(InitialPreferenceData initialPreferenceData);
}
