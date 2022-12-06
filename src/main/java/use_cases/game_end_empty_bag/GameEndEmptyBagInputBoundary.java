package use_cases.game_end_empty_bag;

import CoreEntities.Player.Player;
import core_entities.game_parts.Bag;

public interface GameEndEmptyBagInputBoundary {
    /**
    Boolean method to determine whether game ends given a bag and the players
     */

    boolean gameEndEmptyBag(Bag bag, Player p1, Player p2);
}
