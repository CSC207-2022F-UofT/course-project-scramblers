package io.ui.logic;

import take_turn.*;
import core_entities.game_parts.GameState;
import launch_new_game_use_case.*;
import place_word_refill_user_story.*;
import use_cases.reload_game_use_case.ReloadGameOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameResponseModel;
import use_cases.save_game_use_case.SaveGameOutputBoundary;

//basis for most the dependency injections as this allows us to consolidate similar tasks and functions
public class Presenter implements LaunchGameOutputBoundary,
        TakeTurnOutputBoundary,
        PlaceWordRefillOutputBoundary,
        SaveGameOutputBoundary,
        ReloadGameOutputBoundary{
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
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setBoard(GameState.getBoard().getLetterGrid());
    }

    @Override
    public void updateViewModel(String save_message) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(save_message);
    }

    @Override
    public void updateViewModel(ReloadGameResponseModel responseModel) {
        assert this.VIEW_MODEL_INTERFACE != null;
    }

    public void prepareSuccessView(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText("Could not place word.");
    }

    @Override
    public void updateRack(TakeTurnOutputData updateinfo) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.updateDisplayLetterRack(updateinfo.getRack().toCharArray());
        this.VIEW_MODEL_INTERFACE.setMessageText(updateinfo.getWordPlaced()+" has been placed start on square ("
                +updateinfo.getStart().getXCoordinate()+", "+updateinfo.getStart().getYCoordinate()+").");
    }

    @Override
    public void prepareFailView(String csv_file_not_found) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(csv_file_not_found);
    }

    @Override
    public void prepareFailViewAfterExchangingLetters(String cannot_exchange){
        assert  this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(cannot_exchange);
    }

    @Override
    public void winning(String winningPlayer) {
        this.VIEW_MODEL_INTERFACE.setMessageText(winningPlayer);
    }
}
