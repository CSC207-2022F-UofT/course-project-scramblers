package core_entities.game_parts.use_case_turn;

import CoreEntities.IO.TurnBuilderBoundary;

public class TurnBuilder implements TurnBuilderBoundary {

    /**
     * This will be the
     *
     * TurnBuilder is the director of a Builder design pattern than makes either a ComputerWorldBuilder
     * or a HumanWordBuilder.
     * It has one private attribute which is a boolean value for winState, which is set to false on construction.
     *
     */

    private boolean winState;

    public TurnBuilder() {
        this.winState = false;
    }

    public void makeComputerWord(TurnConstructorRecipe C){

    }

    public void makeHumanWord(TurnConstructorRecipe H){

    }
}
