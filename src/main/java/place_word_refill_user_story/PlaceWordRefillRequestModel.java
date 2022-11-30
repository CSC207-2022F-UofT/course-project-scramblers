package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public class PlaceWordRefillRequestModel {
    final PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary;
    final String word;
    final Coordinate c1;
    final Coordinate c2;

    public PlaceWordRefillRequestModel(PlaceWordRefillOutputBoundary placeWordRefillOutputBoundary,
                                       String word, Coordinate c1, Coordinate c2) {
        this.placeWordRefillOutputBoundary = placeWordRefillOutputBoundary;
        this.word = word;
        this.c1 = c1;
        this.c2 = c2;
    }

    public PlaceWordRefillOutputBoundary getPlaceWordRefillPresenter() {
        return placeWordRefillOutputBoundary;
    }
}
