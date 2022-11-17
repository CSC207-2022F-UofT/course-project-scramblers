package place_word_refill_user_story;

import CoreEntities.Player.Player;
import core_entities.game_parts.Bag;
import core_entities.game_parts.Board;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public class PlaceWordRefillInteractor implements PlaceWordInputBoundary, RefillInputBoundary{

    final PlaceWordRefillController placeWordRefillController;
    final PlaceWordRefillPresenter placeWordRefillPresenter;

    public PlaceWordRefillInteractor(PlaceWordRefillController placeWordRefillController,
                                     PlaceWordRefillPresenter placeWordRefillPresenter) {
        this.placeWordRefillController = placeWordRefillController;
        this.placeWordRefillPresenter = placeWordRefillPresenter;
    }

    @Override
    public PlaceWordResponseModel placeWord(Player player, String word, Coordinate c1,
                                                  Coordinate c2, Board board, GameState gameState) {
        return null;
    }

    @Override
    public RefillResponseModel refill(Player player, Bag bag, Board board, GameState gameState) {
        return null;
    }
}
