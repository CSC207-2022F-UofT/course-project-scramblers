package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Tile;

import java.util.ArrayList;

public class tileCollector {
    /**
     * Collect all the Tiles that need to be placed on the board, including those that are already on the board.
     * @param player The player attempting the move.
     * @param word The word that is to be placed.
     * @param existingOnBoard An array of Tiles that are already on the board but are needed to place the word.
     * @return An array of all the Tiles that need to be placed.
     */
    public Tile[] collectTiles(Player player, String word, ArrayList<Tile> existingOnBoard) {
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
}
