package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public class PlaceWordRefillRequestModel {
    final PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary;
    final String word;
    final Player player;
    final Coordinate c1;
    final Coordinate c2;
    final GameState gameState;

    public PlaceWordRefillRequestModel(PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary, Player player,
                                       String word, Coordinate c1, Coordinate c2, GameState gameState) {
        this.placeWordRefillOutputBoundary = placeWordRefillOutputBoundary;
        this.word = word;
        this.player = player;
        this.c1 = c1;
        this.c2 = c2;
        this.gameState = gameState;
    }

    public PlaceWordRefillOutputBoundary getPlaceWordRefillPresenter() {
        return placeWordRefillOutputBoundary;
    }
}
