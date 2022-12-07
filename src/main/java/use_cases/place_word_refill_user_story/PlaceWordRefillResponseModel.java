package use_cases.place_word_refill_user_story;

import core_entities.player.Player;

public class PlaceWordRefillResponseModel {
    boolean success;
    String wordPlaced;
    Player player;
    int score;

    public PlaceWordRefillResponseModel(boolean success, String wordPlaced, Player player, int score) {
        this.success = success;
        this.wordPlaced = wordPlaced;
        this.player = player;
        this.score = score;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getPlayerScore() {
        return this.score;
    }
}
