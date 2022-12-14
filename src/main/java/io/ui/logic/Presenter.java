package io.ui.logic;

import core_entities.game_parts.GameState;
import use_cases.launch_new_game_use_case.LaunchGameOutputBoundary;
import use_cases.launch_new_game_use_case.LaunchGameResponseModel;
import use_cases.place_word_refill_user_story.PlaceWordRefillOutputBoundary;
import use_cases.place_word_refill_user_story.PlaceWordRefillResponseModel;
import use_cases.reload_game_use_case.ReloadGameOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameResponseModel;
import use_cases.save_game_use_case.SaveGameOutputBoundary;
import use_cases.take_turn.TakeTurnOutputBoundary;
import use_cases.take_turn.TakeTurnOutputData;

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
        this.VIEW_MODEL_INTERFACE.setColors(responseModel.getBoardLayout());
        this.VIEW_MODEL_INTERFACE.updateDisplayLetterRack(responseModel.getLetterRack());
        this.VIEW_MODEL_INTERFACE.setScore(responseModel.getScore());
    }

    @Override
    public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setBoard(GameState.getBoard().getLetterGrid());
        this.VIEW_MODEL_INTERFACE.setScore(placeWordRefillResponseModel.getPlayerScore());
    }

    @Override
    public void updateViewModel(String save_message) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(save_message);
    }

    @Override
    public void updateViewModel(ReloadGameResponseModel responseModel) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setScore(responseModel.getPlayerScore());
        this.VIEW_MODEL_INTERFACE.setColors(responseModel.getMultiplierGrid());
        this.VIEW_MODEL_INTERFACE.setBoard(responseModel.getCharacterGrid());
        this.VIEW_MODEL_INTERFACE.updateDisplayLetterRack(responseModel.getLetterRack());
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
        this.VIEW_MODEL_INTERFACE.setScore(updateinfo.getPlayerScore());
    }

    public void updateOnlyRack(TakeTurnOutputData updateInfo) {
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.updateDisplayLetterRack(updateInfo.getRack().toCharArray());
        this.VIEW_MODEL_INTERFACE.setScore(updateInfo.getPlayerScore());
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
        assert this.VIEW_MODEL_INTERFACE != null;
        this.VIEW_MODEL_INTERFACE.setMessageText(winningPlayer);
    }
}
