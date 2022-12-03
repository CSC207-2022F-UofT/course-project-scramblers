package io.ui.logic;
import Take_Turn.TakeTurnOutputBoundary;
import Take_Turn.TakeTurnOutputData;
import launch_new_game_use_case.LaunchGameOutputBoundary;
import launch_new_game_use_case.LaunchGameResponseModel;
import place_word_refill_user_story.PlaceWordRefillOutputBoundary;
import place_word_refill_user_story.PlaceWordRefillResponseModel;
import use_cases.reload_game_use_case.ReloadGameOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameResponseModel;
import use_cases.save_game_use_case.SaveGameOutputBoundary;


public class Presenter implements LaunchGameOutputBoundary, TakeTurnOutputBoundary, PlaceWordRefillOutputBoundary, SaveGameOutputBoundary, ReloadGameOutputBoundary{

    private final PresenterViewModelInterface VIEW_MODEL_INTERFACE;

    /**
     * Use only for testing
     */
    public Presenter(){
        this.VIEW_MODEL_INTERFACE = null;
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
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setBoard(responseModel.getBoardLayout());
    }

    @Override
    public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        // TODO
    }

    @Override
    public void updateViewModel(String save_message) {
        // TODO
    }

    @Override
    public void updateViewModel(ReloadGameResponseModel responseModel) {
        assert this.VIEW_MODEL_INTERFACE != null;
    }
    
    public void prepareSuccessView(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        this.VIEW_MODEL_INTERFACE.setMessageText("Could not place word.");
    }

    @Override
    public void updateRack(TakeTurnOutputData updateinfo) {
        // update the rack only
    }

    @Override
    public void prepareFailView(String csv_file_not_found) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(csv_file_not_found);
    }
}
