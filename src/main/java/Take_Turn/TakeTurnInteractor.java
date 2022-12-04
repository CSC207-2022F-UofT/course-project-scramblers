package Take_Turn;

import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;
import place_word_refill_user_story.PlaceWordInputBoundary;
import place_word_refill_user_story.PlaceWordRefillRequestModel;
import use_cases.exchange_rack_letters.ExchangeLettersInputBoundary;
import use_cases.save_game_use_case.SaveGameInputBoundary;

public class TakeTurnInteractor implements TakeTrunInputBoundary{

    private final TakeTurnOutputBoundary presenter;
    private final PlaceWordInputBoundary placeword;
    private final ExchangeLettersInputBoundary exchangeLettersInteractor;
    private final SaveGameInputBoundary saveGame;


    public TakeTurnInteractor(TakeTurnOutputBoundary presenter,
                              PlaceWordInputBoundary placeword,
                              ExchangeLettersInputBoundary exchangeLettersInteractor,
                              SaveGameInputBoundary saveGameInputBoundary) {
        this.presenter = presenter;
        this.placeword = placeword;
        this.exchangeLettersInteractor = exchangeLettersInteractor;
        this.saveGame = saveGameInputBoundary;
    }

    /**
     * Call place_word_refill_user_story to try to place the word.
     * If the word can be placed, move to the next turn and show the new board to the user
     * If the word cannot be placed, show error message to the user and ask them to try again
     * If the start coordinate is equals to (-1, -1) it is considered to be exchange tiles with bag in this turn
     * The new rack will be shown to the plauer and move to the next turn
     */
    @Override
    public void taketurn(TakeTrunInputData inputData) {
        Coordinate exchange = new Coordinate(-1, -1);
        if (inputData.getStart().equals(exchange)){
            // if the start coordinate is (-1, -1) exchange tiles with bag
            if (this.exchangeLettersInteractor.exchangeLetters(inputData.getWord())) {
                TakeTurnOutputData updateinfo1 = new TakeTurnOutputData(inputData.getWord(),
                        GameState.getCurrentPlayer().getRack(), inputData.getStart(), inputData.getEnd());
                this.presenter.updateRack(updateinfo1);
                GameState.changeTurn();
                saveGame.save();
            }
            else{
                presenter.prepareFailView("Letter cannot be exchange, please try again");
            }
        }
        // try to place thr word, return true if the word is placed
        PlaceWordRefillRequestModel data = new PlaceWordRefillRequestModel(inputData.getWord(),
                inputData.getStart(), inputData.getEnd());
        boolean a = this.placeword.placeWordRefill(data);
        if (a){
            //the word is placed, change turn and save the current game state
            GameState.changeTurn();
            saveGame.save();
        }
        else {
            presenter.prepareFailView("The word could not be placed. Please try another word");
        }
    }
}
