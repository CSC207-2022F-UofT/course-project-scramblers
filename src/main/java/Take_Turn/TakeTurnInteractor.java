package Take_Turn;

import core_entities.game_parts.GameState;
import place_word_refill_user_story.PlaceWordInputBoundary;
import place_word_refill_user_story.PlaceWordRefillInteractor;
import place_word_refill_user_story.PlaceWordRefillResponseModel;
import use_cases.exchange_rack_letters.ExchangeLettersInputBoundary;
import use_cases.exchange_rack_letters.ExchangeLettersInteractor;
import use_cases.save_game_use_case.SaveGameInputBoundary;
import use_cases.save_game_use_case.SaveGameInteractor;

public class TakeTurnInteractor implements TakeTrunInputBoundary{

    private final TakeTrunInputData inputData;
    private final TakeTurnOutputBoundary presenter;
    private final PlaceWordInputBoundary placeword;
    private final SaveGameInputBoundary saveGame;
    private static int tries = 0;


    public TakeTurnInteractor(TakeTrunInputData inputData, TakeTurnOutputBoundary presenter,
                              PlaceWordInputBoundary placeword,
                              SaveGameInputBoundary saveGameInputBoundary) {
        this.inputData = inputData;
        this.presenter = presenter;
        this.placeword = placeword;
        this.saveGame = saveGameInputBoundary;
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
        //Need new version of place word refill user sotry
        PlaceWordRefillResponseModel a = this.placeword.placeWordRefill(GameState.getCurrentPlayer(),
                this.inputData.getWord(), this.inputData.getStart(), this.inputData.getEnd());
        if (a.isSuccess()){
            //update the view model of the board and change turn
            //update rack thing need to be done later
            TakeTurnOutputData updateinfo = new TakeTurnOutputData(this.inputData.getWord(),
                    GameState.getCurrentPlayer().getRack(), this.inputData.getStart(), this.inputData.getEnd());
            this.presenter.updateBoard(updateinfo);
            tries = 0;
            GameState.changeTurn();
            saveGame.save();
        }
        else{
            // the word cannot be placed
            tries += 1;
            if (tries == 3){
                // exchange tiles with bag
                ExchangeLettersInputBoundary b = new ExchangeLettersInteractor();
                b.exchangeLetters(this.inputData.getWord());
                TakeTurnOutputData updateinfo1 = new TakeTurnOutputData(this.inputData.getWord(),
                        GameState.getCurrentPlayer().getRack(), this.inputData.getStart(), this.inputData.getEnd());
                this.presenter.updateRack(updateinfo1);
                GameState.changeTurn();
                saveGame.save();
                }
            else{
                // show the view model that ask the player to try again
                String error = "Word cannot be placed, please try again" + (3 - tries) + "remaining";
                presenter.prepareFailView(error);
            }
            }
    }
}
