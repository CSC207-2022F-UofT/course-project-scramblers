package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.*;

import java.util.ArrayList;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary{

    final PlaceWordRefillController placeWordRefillController;
    final PlaceWordRefillPresenter placeWordRefillPresenter;

    public PlaceWordRefillInteractor(PlaceWordRefillRequestModel requestModel) {
        this.placeWordRefillController = requestModel.placeWordRefillController;
        this.placeWordRefillPresenter = requestModel.placeWordRefillPresenter;
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
    public PlaceWordRefillResponseModel placeWord(Player player, String word, Coordinate c1,
                                                  Coordinate c2, GameState gameState) {
        Board board = gameState.getBoard();
        ArrayList<Tile> existingOnBoard = new ArrayList<>();
        if (!verifyLetters(player, word, c1, c2, gameState, existingOnBoard)) {
            return placeWordRefillPresenter.prepareFailView("Letters are not available for this word to be placed.");
        }
        if (!boardCheck(word, c1, c2, gameState))
            return placeWordRefillPresenter.prepareFailView("Placement of word is not valid.");
        Tile[] toPlace = collectTiles(player, word, existingOnBoard);
        board.placeTiles(toPlace, c1, c2);
        player.getRack().refill();
        return placeWordRefillPresenter.prepareSuccessView(new PlaceWordRefillResponseModel(true, word, player));
    }

    /**
     * Collect all the Tiles that need to be placed on the board, including those that are already on the board.
     * @param player The player attempting the move.
     * @param word The word that is to be placed.
     * @param existingOnBoard The array of Tiles that need to be placed.
     * @return All the Tile objects that need to be placed in an array.
     */
    private Tile[] collectTiles(Player player, String word, ArrayList<Tile> existingOnBoard) {
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

    /**
     * Check the area on the board to see if the move can be made. The existing tiles on the board are also checked
     * if they are in the correct position.
     * @param word The word that is being attempted to be placed.
     * @param c1 The starting coordinate of the word trying to be placed.
     * @param c2 The ending coordinate of the word trying to be placed.
     * @param gameState The state of the game prior to the move being made.
     * @return Whether the board space is valid for this move to be made.
     */
    private boolean boardCheck(String word, Coordinate c1, Coordinate c2, GameState gameState) {
        Board board = gameState.getBoard();
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

    /**
     * Verify if the Tiles exist in the player's rack and/or the board for this word to be placed.
     * @param player The player attempting this move.
     * @param word The word trying to be placed.
     * @param c1 The starting coordinate of the word trying to be placed.
     * @param c2 The ending coordinate of the word trying to be placed.
     * @param gameState The state of the game prior to the move being made.
     * @param onBoard The list of Tiles on the board that are involved in the placement of this word.
     * @return Whether the Tiles for this move exist in the player's rack and/or on the board for this word to be placed.
     */
    private boolean verifyLetters(Player player, String word, Coordinate c1, Coordinate c2,
                                  GameState gameState, ArrayList<Tile> onBoard) {
        // Create an array of all the letters in the player rack and the board as characters
        Board board = gameState.getBoard();
        ArrayList<Character> existingTileLetters = new ArrayList<>();
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
        ArrayList<Character> wordLetters = new ArrayList<>();
        for (int k = 0; k < word.length(); k++){
            wordLetters.add((char) word.indexOf(k));
        }
        for (Character wordLetter : wordLetters) {
            try {
                Boolean result = existingTileLetters.contains(wordLetter);
            } catch (Exception IndexOutOfBoundsException) {
                return false;
            }
        }
        return true;
    }
}
