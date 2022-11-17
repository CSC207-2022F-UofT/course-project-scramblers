package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Board;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public interface PlaceWordInputBoundary {
    PlaceWordResponseModel placeWord(Player player, String word, Coordinate c1,
                                           Coordinate c2, Board board, GameState gameState);

}
