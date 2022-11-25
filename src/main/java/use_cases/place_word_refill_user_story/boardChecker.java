package use_cases.place_word_refill_user_story;

import core_entities.game_parts.Board;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public class boardChecker {
    /**
     * Check the area on the board to see if the move can be made. The existing tiles on the board are also checked
     * if they are in the correct position.
     * @param word The word that is being attempted to be placed.
     * @param c1 The starting coordinate of the word trying to be placed.
     * @param c2 The ending coordinate of the word trying to be placed.
     * @param gameState The state of the game prior to the move being made.
     * @return Whether the board space is valid for this move to be made.
     */
    public boolean boardCheck(String word, Coordinate c1, Coordinate c2, GameState gameState) {
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
}
