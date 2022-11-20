package core_entities.game_parts.use_case_turn;

public class ComputerWordBuilder implements TurnConstructorRecipe{

    private WordNode other;
    private ComputerWord node;

    public ComputerWordBuilder(WordNode node) {
        this.other = node;
    }

    /**
     *
     */
    @Override
    public void getLocation() {

    }

    /**
     *
     */
    @Override
    public void getWord() {

    }

    /**
     *
     */
    @Override
    public void verifyWord() {

    }

    /**
     *
     */
    @Override
    public void verifyLocation() {

    }

    /**
     *
     */
    @Override
    public void calculateWord() {

    }

    /**
     *
     */
    @Override
    public void updateScore() {

    }

    /**
     *
     */
    @Override
    public void updateTiles() {

    }
}
