package io.ui.logic;

import Take_Turn.TakeTurnOutputBoundary;
import Take_Turn.TakeTurnOutputData;
import launch_new_game_use_case.*;
import place_word_refill_user_story.*;
import use_cases.exchange_rack_letters.ExchangeLettersOutputBoundary;

public class Presenter implements LaunchGameOutputBoundary, TakeTurnOutputBoundary, PlaceWordRefillOutputBoundary, ExchangeLettersOutputBoundary{

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
        this.VIEW_MODEL_INTERFACE.setBoard(responseModel.getBoardLayout());
    }

    @Override
    public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        // TODO
    }

    @Override
    public void prepareSuccessView(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        this.VIEW_MODEL_INTERFACE.setMessageText("Could not place word.");
    }

    @Override
    public void updateRack(TakeTurnOutputData updateinfo) {
        // update the rack only
    }

    @Override
    public void prepareFailView(String csv_file_not_found) {
        this.VIEW_MODEL_INTERFACE.setMessageText(csv_file_not_found);
    }

    @Override
    public void updateViewModelAfterExchange() {
        this.VIEW_MODEL_INTERFACE.updateLetterRacks();
    }
}
