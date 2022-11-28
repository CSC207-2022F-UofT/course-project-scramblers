package io.ui.logic;
import launch_new_game_use_case.LaunchGameOutputBoundary;
import launch_new_game_use_case.LaunchGameResponseModel;

public class Presenter implements LaunchGameOutputBoundary{

    private final PresenterViewModelInterface VIEW_MODEL_INTERFACE;

    /**
     * Default constructor
     */
    public Presenter(PresenterViewModelInterface view_model_interface) {
        VIEW_MODEL_INTERFACE = view_model_interface;
    }

    @Override
    public void updateViewModel(LaunchGameResponseModel responseModel) {

    }

    @Override
    public void prepareFailView(String csv_file_not_found) {
        this.VIEW_MODEL_INTERFACE.setMessageText(csv_file_not_found);
    }
}
