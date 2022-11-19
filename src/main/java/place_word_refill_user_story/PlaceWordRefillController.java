package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Board;
import core_entities.game_parts.GameState;

public interface PlaceWordRefillController {
    boolean inDictionary(String word);
    boolean inRack(String word, Player player);
    boolean validOnBoard(String word, Player player, Board board, GameState gameState);
}
