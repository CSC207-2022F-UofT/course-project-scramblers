package use_cases.game_end_empty_bag;

import core_entities.player.*;
import core_entities.game_parts.Bag;


public class GameEndEmptyBagInteractor implements GameEndEmptyBagInputBoundary{

    private final GameEndEmptyBagOutputBoundary outputBoundary;

    public GameEndEmptyBagInteractor(GameEndEmptyBagOutputBoundary GameEndEmptyBagOutputBoundary) {
        this.outputBoundary = GameEndEmptyBagOutputBoundary;
    }

    /**
     *executes in the checkWin() code to see whether the game is over or not because the bag is empty. This information
     * is then used to determine which player has the higher score and that would be delt with after the checkWin()
     * method.
     *
     * @param bag is an instance of the bag being used by GameState, and is passed in when the gameEndEmptyBag method is
     *           called.
     * @return true if the game is over because the bag is empty and false otherwise.
     */

    @Override
    public Boolean gameEndEmptyBag(Bag bag) {
        if(bag.isEmpty()){
            this.outputBoundary.prepareSuccessViewGameEndEmptyBag();
            return true;
        }
        else{
            return false;
        }


    }
}
