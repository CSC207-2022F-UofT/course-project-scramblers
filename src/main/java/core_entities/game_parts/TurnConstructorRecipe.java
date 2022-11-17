package CoreEntities.GameParts;

/**
    This interface contains a 'recipe' for each turn cycle.
    These are the same for any player, but the methods will be overriden differently
    depending on human or Computer.

    The ATTRIBUTE winState is a boolean value that defaults as false meaning
    that there is no current win state. And thus, updateScore and getTile can
    result in this value change to true, meaning the game has been won.



*/

public interface TurnConstructorRecipe {


    public boolean winState = false;

    public void getLocation();

    public void verifyLocation();

    public void getWord();

    public void verifyWord();

    public void calculateWord();

    public void updateScore();

    public void updateTiles();
}
