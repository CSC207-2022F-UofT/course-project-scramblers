package place_word_refill_user_story;

import core_entities.game_parts.*;
import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

    final PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary;
    final tileCollector tileCollector;
    final boardChecker boardChecker;
    final letterVerifier letterVerifier;

    /**
     * Use Case Interactor for placing a word if valid and possible, and refilling the player's LetterRack. Implements
     * the Facade design pattern by delegating the tasks of collecting the tiles to place, check of the board space,
     * and the verification of the word and tiles.
     * @param requestModel Request model object with the needed information.
     * @param presenter Presenter that implements PlaceWordRefillOutputBoundary
     */
    public PlaceWordRefillInteractor(PlaceWordRefillRequestModel requestModel, PlaceWordRefillOutputBoundary presenter) {
        this.placeWordRefillOutputBoundary = presenter;
        this.tileCollector = new tileCollector(); // Delegating the task of collecting the tiles to place
        this.boardChecker = new boardChecker(); // Delegating the task of checking the board space
        this.letterVerifier = new letterVerifier(); // Delegating the task of verifying the word and tiles
        placeWordRefill(requestModel);
    }

    /**
     * Place the word if valid and possible, and then refill the LetterRack to comply with the rules. The Tiles of the
     * Board and Player's LetterRack are first verified to see if these Tiles are available. The board is then checked
     * if the area is empty, and if any existing Tiles on the board are in the correct spot. Then, the tiles are
     * placed on the board, and the LetterRack is refilled.
     */
    @Override
    public void placeWordRefill(PlaceWordRefillRequestModel requestModel) {
        Board board = GameState.getBoard();
        ArrayList<Tile> existingOnBoard = new ArrayList<>();
        if (!letterVerifier.verifyLetters(GameState.getCurrentPlayer(), requestModel.word, requestModel.c1,
                requestModel.c2, existingOnBoard)) {
            placeWordRefillOutputBoundary.prepareFailView("Letters are not available for this word to be placed.");
        }
        if (!boardChecker.boardCheck(requestModel.word, requestModel.c1, requestModel.c2))
            placeWordRefillOutputBoundary.prepareFailView("Placement of word is not valid.");
        Tile[] toPlace = tileCollector.collectTiles(GameState.getCurrentPlayer(), requestModel.word, existingOnBoard);
        board.placeTiles(toPlace, requestModel.c1, requestModel.c2);
        GameState.getCurrentPlayer().getRack().refill();
        placeWordRefillOutputBoundary.updateViewModel(new PlaceWordRefillResponseModel(true, requestModel.word,
                GameState.getCurrentPlayer()));
    }
}
