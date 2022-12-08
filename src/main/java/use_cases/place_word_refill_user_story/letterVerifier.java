package use_cases.place_word_refill_user_story;

import core_entities.player.Player;
import core_entities.game_parts.Board;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;
import core_entities.game_parts.Tile;

import java.util.ArrayList;

public class letterVerifier {

    /**
     * Verify if the Tiles exist in the player's rack and/or the board for this word to be placed.
     * @param player The player attempting this move.
     * @param word The word trying to be placed.
     * @param c1 The starting coordinate of the word trying to be placed.
     * @param c2 The ending coordinate of the word trying to be placed.
     * @param onBoard The list of Tiles on the board that are involved in the placement of this word.
     * @return Whether the Tiles for this move exist in the player's rack and/or on the board for this word to be placed.
     */
    public boolean verifyLetters(Player player, String word, Coordinate c1, Coordinate c2, ArrayList<Tile> onBoard) {
        // Create an array of all the letters in the player rack and the board as characters
        Board board = GameState.getBoard();
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
