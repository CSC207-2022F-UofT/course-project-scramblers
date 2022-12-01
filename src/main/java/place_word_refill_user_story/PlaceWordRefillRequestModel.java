package place_word_refill_user_story;

import core_entities.game_parts.Coordinate;


public class PlaceWordRefillRequestModel {
    final String word;
    final Coordinate c1;
    final Coordinate c2;

    public PlaceWordRefillRequestModel(String word, Coordinate c1, Coordinate c2) {
        this.word = word;
        this.c1 = c1;
        this.c2 = c2;
    }
}
