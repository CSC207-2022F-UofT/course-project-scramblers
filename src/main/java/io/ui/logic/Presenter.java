package io.ui.logic;
import Take_Turn.TakeTurnOutputBoundary;
import Take_Turn.TakeTurnOutputData;
import launch_new_game_use_case.LaunchGameOutputBoundary;
import launch_new_game_use_case.LaunchGameResponseModel;
import place_word_refill_user_story.PlaceWordRefillOutputBoundary;
import place_word_refill_user_story.PlaceWordRefillResponseModel;

public class Presenter implements LaunchGameOutputBoundary, TakeTurnOutputBoundary, PlaceWordRefillOutputBoundary{

    private final PresenterViewModelInterface VIEW_MODEL_INTERFACE;

    public Presenter(){
        VIEW_MODEL_INTERFACE = null;
    }

    /**
     * Default constructor
     * @param view_model_interface interface reference to be used.
     */
    public Presenter(PresenterViewModelInterface view_model_interface) {
        VIEW_MODEL_INTERFACE = view_model_interface;
    }

    @Override
    public void updateViewModel(LaunchGameResponseModel responseModel) {
        this.VIEW_MODEL_INTERFACE.setBoard(responseModel.getBoardLayout());
    }

    @Override
    public void updateBoard(TakeTurnOutputData updateinfo) {
        // update the board and the rack based on the given info
    }

    @Override
    public void updateRack(TakeTurnOutputData updateinfo) {
        // update the rack based on the given info
    }

    @Override
    public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        // TODO
    }

    @Override
    public void prepareFailView(String csv_file_not_found) {
        this.VIEW_MODEL_INTERFACE.setMessageText(csv_file_not_found);
    }
}
