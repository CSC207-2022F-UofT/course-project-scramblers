package use_cases.place_word_refill_user_story;

import core_entities.player.Player;

public class PlaceWordRefillResponseModel {
    boolean success;
    String wordPlaced;
    Player player;

    public PlaceWordRefillResponseModel(boolean success, String wordPlaced, Player player) {
        this.success = success;
        this.wordPlaced = wordPlaced;
        this.player = player;
    }

    public boolean isSuccess() {
        return success;
    }
}
