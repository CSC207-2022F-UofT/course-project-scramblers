package Take_Turn;

import core_entities.game_parts.GameState;
import place_word_refill_user_story.PlaceWordInputBoundary;
import place_word_refill_user_story.PlaceWordRefillInteractor;
import place_word_refill_user_story.PlaceWordRefillResponseModel;

public class TakeTurnInteractor implements TakeTrunInputBoundary{

    private final TakeTrunInputData inputData;
    private final TakeTurnOutputBoundary presenter;
    private final PlaceWordInputBoundary placeword;
    private static int tries = 0;


    public TakeTurnInteractor(TakeTrunInputData inputData, TakeTurnOutputBoundary presenter, PlaceWordInputBoundary placeword) {
        this.inputData = inputData;
        this.presenter = presenter;
        this.placeword = placeword;
    }

    @Override
    /**
     * Call place_word_refill_user_story to try to place the word.
     * If the word can be placed, move to the next turn and show the new board to the user
     * If the word cannot be placed, show error message to the user and ask them to try again
     * If the user attemps three times and still cannot find a valid word, the player is force to exchange tiles with
     * bag in this turn instead. The new rack will be shown to the plauer and move to the next turn
     */
    public void taketurn() {
        PlaceWordRefillResponseModel a = this.placeword.placeWordRefill(this.inputData.getCurrplayer(),
                this.inputData.getWord(), this.inputData.getStart(), this.inputData.getEnd(), this.inputData.getGameState());
        if (a.isSuccess()){
            //update the view model of the board and change turn
            //update rack thing need to be done later
            TakeTurnOutputData updateinfo = new TakeTurnOutputData(this.inputData.getWord(),
                    this.inputData.getCurrplayer().getRack(), this.inputData.getStart(), this.inputData.getEnd());
            this.presenter.updateBoard(updateinfo);
            tries = 0;
            GameState.changeTurn();
        }
        else{
            // the word cannot be placed
            tries += 1;
            if (tries == 3){
                //Joseph's user story exchange letter
                GameState.changeTurn();
            }
            else{
                // show the view model that ask the player to try again
                presenter.prepareFailView("Word cannot be placed, please try again");
            }
            }
    }
}
