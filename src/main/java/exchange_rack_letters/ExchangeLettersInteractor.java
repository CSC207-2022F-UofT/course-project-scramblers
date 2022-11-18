package exchange_rack_letters;
import core_entities.game_parts.*;

public class ExchangeLettersInteractor implements ExchangeLettersInputBoundary{

    private GameState gameRef;

    public ExchangeLettersInteractor(GameState gameInputRef){
        this.gameRef = gameInputRef;
    }

    /**
     * executes the operation to exchange characters from the bag and player's letter rack
     * the exhcanged letters are the input tiles
     * @param tileInputArray
     * @return true if method succeeds and fails if not.
     */
    @Override
    public boolean exchangeLetters(Tile[] tileInputArray){

        return true;
    }
}
