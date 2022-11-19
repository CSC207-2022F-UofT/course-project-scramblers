package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.*;

import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

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
        ArrayList<Tile> existingOnBoard = new ArrayList<Tile>();
        if (!verifyLetters(player, word, c1, c2, board, existingOnBoard)) {
            return placeWordRefillPresenter.prepareFailView("Letters are not available for this word to be placed.");
        }
        // Check if the area on the board is empty, or contains the right characters at the right location
        if (!boardCheck(word, c1, c2, board))
            return placeWordRefillPresenter.prepareFailView("Placement of word is not valid.");
        // Create the list of Tiles to place on the board, removing them from the player's LetterRack
        Tile[] toPlace = collectTiles(player, word, existingOnBoard);
        // Place these tiles on the board
        board.placeTiles(toPlace, c1, c2);
        // Refill the player's rack
        player.getRack().refill();
        return placeWordRefillPresenter.prepareSuccessView(new PlaceWordRefillResponseModel(true));
    }

    private static Tile[] collectTiles(Player player, String word, ArrayList<Tile> existingOnBoard) {
        Tile[] toPlace = new Tile[word.length()];
        for (int k = 0; k < word.length(); k++){
            for (Tile t: player.getRack().getLETTERS()){
                if (t.getLetter() == word.charAt(k)) {
                    toPlace[k] = (t);
                }
                else {
                    for (Tile t2: existingOnBoard){
                        if (t2.getLetter() == word.charAt(k)) {
                            toPlace[k] = (t2);
                        }
                    }
                }
            }
        }
        player.getRack().removeLetters(word);
        return toPlace;
    }

    private boolean boardCheck(String word, Coordinate c1, Coordinate c2, Board board) {
        // Vertical word placement
        if (c1.getXCoordinate() == c2.getXCoordinate()){
            for (int i = c1.getYCoordinate(); i <= c2.getYCoordinate(); i++){
                if (board.getGrid()[c1.getXCoordinate()][i].getTile() != null){
                    if (word.charAt(i) != board.getGrid()[c1.getXCoordinate()][i].getTile().getLetter()){
                        return false;
                    }
                }
            }
        }
        // Horizontal word placement
        else {
            for (int j = c1.getXCoordinate(); j <= c2.getXCoordinate(); j++){
                if (board.getGrid()[j][c1.getYCoordinate()].getTile() != null){
                    if (word.charAt(j) != board.getGrid()[j][c1.getYCoordinate()].getTile().getLetter()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean verifyLetters(Player player, String word, Coordinate c1, Coordinate c2, Board board, ArrayList<Tile> onBoard) {
        // Create an array of all the letters in the player rack and the board as characters
        ArrayList<Character> existingTileLetters = new ArrayList<Character>();
        for (int i = 0; i < player.getRack().getLETTERS().length; i++) {
            existingTileLetters.add(player.getRack().getLETTERS()[i].getLetter());
        }
        // Vertical word placement
        if (c1.getXCoordinate() == c2.getXCoordinate()){
            for (int i = c1.getYCoordinate(); i <= c2.getYCoordinate(); i++){
                if (board.getGrid()[c1.getXCoordinate()][i].getTile() != null){
                    existingTileLetters.add(board.getGrid()[c1.getXCoordinate()][i].getTile().getLetter());
                    onBoard.add(board.getGrid()[c1.getXCoordinate()][i].getTile());
                }
            }
        }
        // Horizontal word placement
        else {
            for (int j = c1.getXCoordinate(); j <= c2.getXCoordinate(); j++){
                if (board.getGrid()[j][c2.getXCoordinate()].getTile() != null){
                    existingTileLetters.add(board.getGrid()[j][c2.getXCoordinate()].getTile().getLetter());
                    onBoard.add(board.getGrid()[j][c2.getXCoordinate()].getTile());
                }
            }
        }
        // Create an array of all the letters in the word as characters
        ArrayList<Character> wordLetters = new ArrayList<Character>();
        for (int k = 0; k < word.length(); k++){
            wordLetters.add((char) word.indexOf(k));
        }
        for (Character wordLetter : wordLetters) {
            try {
                existingTileLetters.contains(wordLetter);
            } catch (Exception IndexOutOfBoundsException) {
                return false;
            }
        }
        return true;
    }
}
