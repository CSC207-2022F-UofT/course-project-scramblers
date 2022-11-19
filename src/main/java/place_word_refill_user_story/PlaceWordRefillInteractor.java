package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.*;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary, RefillInputBoundary{

    final PlaceWordRefillController placeWordRefillController;
    final PlaceWordRefillPresenter placeWordRefillPresenter;

    public PlaceWordRefillInteractor(PlaceWordRefillController placeWordRefillController,
                                     PlaceWordRefillPresenter placeWordRefillPresenter) {
        this.placeWordRefillController = placeWordRefillController;
        this.placeWordRefillPresenter = placeWordRefillPresenter;
    }

    @Override
    public PlaceWordRefillResponseModel placeWord(Player player, String word, Coordinate c1,
                                                  Coordinate c2, Board board, GameState gameState) {
        // Check if the needed Tiles are in the player's LetterRack or on the Board
        PlaceWordRefillResponseModel verifiedLetters = verifyLetters(player, word, c1, c2, board);
        return verifiedLetters;
    }

    @Nullable
    private static PlaceWordRefillResponseModel verifyLetters(Player player, String word, Coordinate c1, Coordinate c2, Board board) {
        // Create an array of all the letters in the player rack and the board as characters
        ArrayList<Character> existingTileLetters = new ArrayList<Character>();
        for (int i = 0; i < player.getRack().getLETTERS().length; i++) {
            existingTileLetters.add(player.getRack().getLETTERS()[i].getLetter());
        }
        // Vertical word placement
        if (c1.getXCoordinate() == c2.getXCoordinate()){
            for (int i = c1.getYCoordinate(); i < c2.getYCoordinate(); i++){
                if (board.getGrid()[c1.getXCoordinate()][i].getTile() != null){
                    existingTileLetters.add(board.getGrid()[c1.getXCoordinate()][i].getTile().getLetter());
                }
            }
        }
        // Horizontal word placement
        else {
            for (int i = c1.getXCoordinate(); i < c2.getXCoordinate(); i++){
                if (board.getGrid()[i][c2.getXCoordinate()].getTile() != null){
                    existingTileLetters.add(board.getGrid()[i][c2.getXCoordinate()].getTile().getLetter());
                }
            }
        }
        // Create an array of all the letters in the word as characters
        ArrayList<Character> wordLetters = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++){
            wordLetters.add((char) word.indexOf(i));
        }
        for (Character wordLetter : wordLetters) {
            try {
                existingTileLetters.contains(wordLetter);
            } catch (Exception IndexOutOfBoundsException) {
                return new PlaceWordRefillResponseModel(false);
            }
        }
        return null;
    }

    @Override
    public PlaceWordRefillResponseModel refill(Player player, Bag bag, Board board, GameState gameState) {
        return null;
    }
}


/* From TurnBuilder: remove getWord, getLocation in exchange for attributes in a RequestModel type class
*  WordLinkedList with Player attribute, coordinates, word itself, next to be injected into TurnBuilder
*       - WordLinkedList is updated in Board.placeTiles (new link for these coordinates, this word, these tiles, this player)
*
* */
