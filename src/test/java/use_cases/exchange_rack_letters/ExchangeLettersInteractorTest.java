package use_cases.exchange_rack_letters;
import CoreEntities.Player.*;
import java.util.*;
import core_entities.game_parts.*;
import org.junit.jupiter.api.*;

public class ExchangeLettersInteractorTest {

    Random rand;
    ExchangeLettersInputBoundary inputBoundary;
    @BeforeEach
    void setup() {
        final Bag BAG_REF = new Bag();
        GameState.setP1(new HumanPlayer("bob", new LetterRack(BAG_REF, 7), 0));
        rand = new Random('1');
        inputBoundary = new ExchangeLettersInteractor(BAG_REF);
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
        boolean result = !(originalTile.equals(GameState.getP1().getRack().getLETTERS()[index]));
        assert result;
    }


    /**
     * Exchange all letters
     */
    @Test
    void AllLettersSwap() {
        String inputString = tileArrayToString(GameState.getP1().getRack().getLETTERS());
        Tile[] inputTileArray = GameState.getP1().getRack().getLETTERS();
        assert inputBoundary.exchangeLetters(inputString);
        Tile[] outputTileArray = GameState.getP1().getRack().getLETTERS();
        for(int x = 0; x < outputTileArray.length; x++){
            boolean result = outputTileArray[x].equals(inputTileArray[x]);
            assert result;
        }
    }

    /**
     * No letters wanted to be swapped so the array is empty.
     */
    @Test
    void NoLetterSwap() {

    }

    /**
     * Some/all letters no present in rack
     */
    @Test
    void LettersNotPresent() {

    }

    private String tileArrayToString(Tile[] inputTileArray){
        StringBuilder output = new StringBuilder();
        for(Tile tile: inputTileArray){
            output.append(tile.getLetter());
        }
        return output.toString();
    }
}
