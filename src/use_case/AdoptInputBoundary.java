package use_case;

public interface AdoptInputBoundary {
    void execute(AdoptInputData adoptInputData);

    void execute(Adopt adopt);
}
