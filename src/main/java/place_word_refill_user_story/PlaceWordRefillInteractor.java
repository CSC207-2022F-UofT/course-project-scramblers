package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.*;
import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

    final PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary;
    final tileCollector tileCollector;
    final boardChecker boardChecker;
    final letterVerifier letterVerifier;
    final String word;
    final Player player;
    final Coordinate c1;
    final Coordinate c2;
    final GameState gameState;


    public PlaceWordRefillInteractor(PlaceWordRefillRequestModel requestModel, tileCollector tileCollector,
                                     boardChecker boardChecker, letterVerifier letterVerifier) {
        this.placeWordRefillOutputBoundary = requestModel.placeWordRefillOutputBoundary;
        this.tileCollector = tileCollector;
        this.boardChecker = boardChecker;
        this.letterVerifier = letterVerifier;
        this.word = requestModel.word;
        this.player = requestModel.player;
        this.c1 = requestModel.c1;
        this.c2 = requestModel.c2;
        this.gameState = requestModel.gameState;
    }

    /**
     * Place the word if valid and possible, and then refill the LetterRack to comply with the rules. The Tiles of the
     * Board and Player's LetterRack are first verified to see if these Tiles are available. The board is then checked
     * if the area is empty, and if any existing Tiles on the board are in the correct spot. Then, the tiles are
     * placed on the board, and the LetterRack is refilled.
     */
    @Override
    public void placeWordRefill() {
        Board board = gameState.getBoard();
        ArrayList<Tile> existingOnBoard = new ArrayList<>();
        if (!letterVerifier.verifyLetters(player, word, c1, c2, gameState, existingOnBoard)) {
            placeWordRefillOutputBoundary.prepareFailView("Letters are not available for this word to be placed.");
        }
        if (!boardChecker.boardCheck(word, c1, c2, gameState))
            placeWordRefillOutputBoundary.prepareFailView("Placement of word is not valid.");
        Tile[] toPlace = tileCollector.collectTiles(player, word, existingOnBoard);
        board.placeTiles(toPlace, c1, c2);
        player.getRack().refill();
        placeWordRefillOutputBoundary.prepareSuccessView(new PlaceWordRefillResponseModel(true, word, player));
    }
}
