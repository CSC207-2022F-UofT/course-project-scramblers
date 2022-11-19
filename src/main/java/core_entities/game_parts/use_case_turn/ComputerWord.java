package core_entities.game_parts.use_case_turn;

public class ComputerWord extends WordNode implements TurnConstructorRecipe{

    public ComputerWord(WordNode node) {

    }

    @Override
    void setWordNodeValue() {

    }

    @Override
    void setWordOrientation() {

    }

    @Override
    boolean isLast() {
        return false;
    }

    @Override
    WordNode nextWord() {
        return null;
    }

    @Override
    public void getLocation() {

    }

    @Override
    public void getWord() {

    }

    @Override
    public void verifyWord() {

    }

    @Override
    public void verifyLocation() {

    }

    @Override
    public void calculateWord() {

    }

    @Override
    public void updateScore() {

    }

    @Override
    public void updateTiles() {

    }
}
