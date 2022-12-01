package launch_new_game_use_case;

public interface LaunchGameOutputBoundary {
    void updateViewModel(LaunchGameResponseModel responseModel);

    void prepareFailView(String csv_file_not_found);
}
