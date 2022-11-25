package use_cases.place_word_refill_user_story;

import core_entities.player.Player;
import core_entities.game_parts.*;

import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

    final PlaceWordRefillController placeWordRefillController;
    final PlaceWordRefillPresenter placeWordRefillPresenter;
    final tileCollector tileCollector;
    final boardChecker boardChecker;
    final letterVerifier letterVerifier;

    public PlaceWordRefillInteractor(PlaceWordRefillRequestModel requestModel, tileCollector tileCollector,
                                     boardChecker boardChecker, letterVerifier letterVerifier) {
        this.placeWordRefillController = requestModel.placeWordRefillController;
        this.placeWordRefillPresenter = requestModel.placeWordRefillPresenter;
        this.tileCollector = tileCollector;
        this.boardChecker = boardChecker;
        this.letterVerifier = letterVerifier;
    }

    /**
     * Place the word if valid and possible, and then refill the LetterRack to comply with the rules. The Tiles of the
     * Board and Player's LetterRack are first verified to see if these Tiles are available. The board is then checked
     * if the area is empty, and if any existing Tiles on the board are in the correct spot. Then, the tiles are
     * placed on the board, and the LetterRack is refilled.
     * @param player The player attempting this move.
     * @param word The word the player is attempting to place.
     * @param c1 The starting coordinate of the word being placed.
     * @param c2 The ending coordinate of the word being placed.
     * @param gameState The state of the current game prior to the move.
     * @return A PlaceWordRefillResponseModel object.
     */
    @Override
    public PlaceWordRefillResponseModel placeWordRefill(Player player, String word, Coordinate c1,
                                                  Coordinate c2, GameState gameState) {
        Board board = gameState.getBoard();
        ArrayList<Tile> existingOnBoard = new ArrayList<>();
        if (!letterVerifier.verifyLetters(player, word, c1, c2, gameState, existingOnBoard)) {
            return placeWordRefillPresenter.prepareFailView("Letters are not available for this word to be placed.");
        }
        if (!boardChecker.boardCheck(word, c1, c2, gameState))
            return placeWordRefillPresenter.prepareFailView("Placement of word is not valid.");
        Tile[] toPlace = tileCollector.collectTiles(player, word, existingOnBoard);
        board.placeTiles(toPlace, c1, c2);
        player.getRack().refill();
        return placeWordRefillPresenter.prepareSuccessView(new PlaceWordRefillResponseModel(true, word, player));
    }
}
