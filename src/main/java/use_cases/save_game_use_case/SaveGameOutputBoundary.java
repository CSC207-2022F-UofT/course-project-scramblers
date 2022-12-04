package use_cases.save_game_use_case;

public interface SaveGameOutputBoundary {

    void updateViewModel(String save_message);

    void prepareFailView(String error_message);
}
