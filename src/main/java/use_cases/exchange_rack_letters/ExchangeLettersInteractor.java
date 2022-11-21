package use_cases.exchange_rack_letters;

import CoreEntities.Player.HumanPlayer;
import CoreEntities.Player.Player;
import core_entities.game_parts.*;

public class ExchangeLettersInteractor implements ExchangeLettersInputBoundary{

    private final Bag BAG_REFERENCE;
    public ExchangeLettersInteractor(Bag inputBag){
        BAG_REFERENCE = inputBag;
    }

    /**
     * executes the operation to exchange characters from the bag and player's letter rack
     * the exhcanged letters are the input tiles
     * @return true if method succeeds and fails if not.
     */
    @Override
    public boolean exchangeLetters(String inputString){

        if(inputString == null || inputString.length() == 0){ return false; }

        //placeholder (Will be modified later)
        Player playerRef = new HumanPlayer("yoot", new LetterRack(new Bag(), 7), 0);

        Tile[] tileArray = convertStringToTileArray(inputString);
        playerRef.getRack().removeLetters(inputString);
        for (Tile tile: tileArray){
            BAG_REFERENCE.add(tile);
        }

        return true;
    }

    private Tile[] convertStringToTileArray(String inputString){

        Tile[] outputArray = new Tile[inputString.length()];
        int index = 0;

        for(char character: inputString.toCharArray()){
            outputArray[index] = new Tile(character);
        }

        return outputArray;
    }
}
