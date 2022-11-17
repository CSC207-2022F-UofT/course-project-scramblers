package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Bag;
import core_entities.game_parts.Board;
import core_entities.game_parts.GameState;

public interface RefillInputBoundary {

    RefillResponseModel refill(Player player, Bag bag, Board board, GameState gameState);
}
