package io.ui.logic;

import CoreEntities.Player.Player;
import Take_Turn.TakeTurnOutputBoundary;
import Take_Turn.TakeTurnOutputData;
import core_entities.game_parts.GameState;
import launch_new_game_use_case.*;
import place_word_refill_user_story.*;
import use_cases.exchange_rack_letters.ExchangeLettersOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameResponseModel;
import use_cases.save_game_use_case.SaveGameOutputBoundary;

public class Presenter implements LaunchGameOutputBoundary,
        TakeTurnOutputBoundary,
        PlaceWordRefillOutputBoundary,
        SaveGameOutputBoundary,
        ReloadGameOutputBoundary,
        ExchangeLettersOutputBoundary{

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

    @Override
    public void winning(String winningPlayer) {
        // show that a certain player win the game either for run out of tiles (in bag) or reach a certain score
    }

    @Override
    public void updateViewModelAfterExchange() {
        this.VIEW_MODEL_INTERFACE.updateLetterRacks();
    }
}
