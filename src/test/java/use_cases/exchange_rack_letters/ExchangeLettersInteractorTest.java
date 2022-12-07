package use_cases.exchange_rack_letters;

import java.util.*;
import core_entities.game_parts.*;
import core_entities.player.HumanPlayer;
import org.junit.jupiter.api.*;

public class ExchangeLettersInteractorTest {

    Random rand;
    ExchangeLettersInputBoundary inputBoundary;
    boolean result;
    @BeforeEach
    void setup() {
        result = false;
        final Bag BAG_REF = new Bag();
        GameState.setP1(new HumanPlayer("bob", new LetterRack(BAG_REF, 7), 0));
        rand = new Random('1');
        inputBoundary = new ExchangeLettersInteractor();
    }

    /**
     * basic working case
     */
    @Test
    void BaseWorkingCase() {
        int index = rand.nextInt(7);
        String inputString = String.valueOf(
                GameState.getP1().getRack().getLETTERS()[index].getLetter());
        Tile originalTile = GameState.getP1().getRack().getLETTERS()[index];
        assert inputBoundary.exchangeLetters(inputString);
        boolean output_result = !(originalTile.equals(GameState.getP1().getRack().getLETTERS()[index]));
        assert output_result;

        //Testing that the viewModel update works
        // assert result;
    }


    /**
     * Exchange all letters
     */
    @Test
    void AllLettersSwap() {
        String inputString = tileArrayToString(GameState.getP1().getRack().getLETTERS());
        Tile[] inputTileArray = GameState.getP1().getRack().getLETTERS().clone();
        assert inputBoundary.exchangeLetters(inputString);
        Tile[] outputTileArray = GameState.getP1().getRack().getLETTERS();
        for(int x = 0; x < outputTileArray.length; x++){
            boolean output_result = !(outputTileArray[x].equals(inputTileArray[x]));
            assert output_result;
        }

        //Testing that the viewModel update works
//        assert result;
    }

    /**
     * No letters wanted to be swapped so the array is empty.
     */
    @Test
    void NoLetterSwap() {
        Tile[] inputTileArray = GameState.getP1().getRack().getLETTERS().clone();
        assert !(inputBoundary.exchangeLetters(
                generateNonPresentLettersForDefaultRack(tileArrayToString(inputTileArray))));
        Tile[] outputTileArray = GameState.getP1().getRack().getLETTERS();
        for(int x = 0; x < outputTileArray.length; x++){
            boolean output_result = (outputTileArray[x].equals(inputTileArray[x]));
            assert output_result;
        }

        //Testing that the viewModel update works
        assert !result;
    }

    /**
     * Some/all letters no present in rack
     */
    @Test
    void LettersNotPresent() {
        Tile[] inputTileArray = GameState.getP1().getRack().getLETTERS().clone();
        assert !(inputBoundary.exchangeLetters(
                generateNonPresentLettersForDefaultRack(tileArrayToString(inputTileArray))));
        Tile[] outputTileArray = GameState.getP1().getRack().getLETTERS();
        for(int x = 0; x < outputTileArray.length; x++){
            boolean output_result = (outputTileArray[x].equals(inputTileArray[x]));
            assert output_result;
        }

        //Testing that the viewModel update works
        assert !result;
    }

    /**
     * Generates a string with letters not present in the string to represent an input filled with non-present
     * characters
     * @param avoidLetters letters to avoid
     * @return a string with each character not in avoidLetters and len <= 7
     */
    String generateNonPresentLettersForDefaultRack(String avoidLetters){
        StringBuilder output = new StringBuilder();
        for(int x = 'A'; x <= 'Z' && output.length() < 7; x++){
            if(!(checkIfStringContains((char)x, avoidLetters))){
                while(output.length() < 7){
                    output.append((char)x);
                }
            }
        }
        return output.toString();
    }

    /**
     * Check if string contains a character
     * @param inputCharacter character being looked for
     * @param inputString string being searched through
     * @return true iff inputCharacter is in inputString
     */
    boolean checkIfStringContains(char inputCharacter, String inputString){
        for(char character: inputString.toCharArray()){
            if(inputCharacter == character){
                return true;
            }
        }
        return false;
    }

    /**
     * Converts a tile array into a string representation
     * @param inputTileArray the tile array to be represented
     * @return the string representation of inputTileArray
     */
    private String tileArrayToString(Tile[] inputTileArray){
        StringBuilder output = new StringBuilder();
        for(Tile tile: inputTileArray){
            output.append(tile.getLetter());
        }
        return output.toString();
    }
}
