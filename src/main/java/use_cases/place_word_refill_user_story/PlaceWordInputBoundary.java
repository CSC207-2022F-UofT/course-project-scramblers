package use_cases.place_word_refill_user_story;

import core_entities.player.Player;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public interface PlaceWordInputBoundary {
    PlaceWordRefillResponseModel placeWordRefill(Player player, String word, Coordinate c1,
                                           Coordinate c2, GameState gameState);

}
