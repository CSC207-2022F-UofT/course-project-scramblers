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
     * the exchanged letters are the input tiles
     * @return true if method succeeds and fails if not.
     */
    @Override
    public boolean exchangeLetters(String inputString){

        String cleanedString = extractFoundLetters(inputString, GameState.getCurrentPlayer().getRack().getLETTERS());

        Tile[] tileArray = convertStringToTileArray(cleanedString);
        //checks the input
        if(cleanedString.length() == 0){ return false; }

        GameState.getCurrentPlayer().getRack().removeLetters(cleanedString);
        for (Tile tile: tileArray){
            BAG_REFERENCE.add(tile);
        }

        return true;
    }

    /**
     * Convert String into a Tile[] with corresponding scores.
     * @param inputString the inputted string to be converted
     * @return Tile[] representation of inputString
     */
    private Tile[] convertStringToTileArray(String inputString){

        Tile[] outputArray = new Tile[inputString.length()];
        int index = 0;

        for(char character: inputString.toCharArray()){
            outputArray[index] = new Tile(character);
        }

        return outputArray;
    }

    /**
     * Extract the letters found in the rack that are also present with the given parameter
     * @param inputString the inputted String
     * @param inputTileArray the inputted Tile[]
     * @return String of values found in both the Tile[] and inputString
     */
    private String extractFoundLetters(String inputString, Tile[] inputTileArray){
        StringBuilder outputString = new StringBuilder();

        boolean[] foundLetters = new boolean[inputTileArray.length];

        for(char charInString: inputString.toCharArray()){//for each letter in the string
            for(int x = 0; x < inputTileArray.length; x++){ //iterate over the input tile array

                //if the character has a match in the tile array AND is not marked
                if(charInString == inputTileArray[x].getLetter() && !foundLetters[x]){
                    foundLetters[x] = true;
                    outputString.append(charInString);

                    //break the loop
                    x = inputTileArray.length;
                }
            }
        }

        return outputString.toString();
    }
}
