package use_cases.game_end_empty_bag;

import CoreEntities.Player.Player;
import core_entities.game_parts.Bag;

public interface GameEndEmptyBagInputBoundary {
    /**
     Method to determine whether game ends given a bag and the players
     */

    Boolean gameEndEmptyBag(Bag bag);
}
