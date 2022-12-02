package use_cases.reload_game_use_case;

public interface ReloadGameOutputBoundary {
    void updateViewModel(ReloadGameResponseModel responseModel);

    void prepareFailView(String error_message);
}
