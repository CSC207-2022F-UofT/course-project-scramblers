package CoreEntities.GameParts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class LetterRackTest {

    @Test
    public void GeneralCase() {
        //instantiating needed objects
        LetterRack letterRack = new LetterRack(new Bag());
        Tile[] tileArray = letterRack.getLETTERS();
        Random rand = new Random();
        rand.setSeed(0);

        //Testing removeLetters
        int removedIndex = rand.nextInt(tileArray.length);
        //admittedly weird string conversion
        String toRemove = "" + tileArray[removedIndex].getLetter();
        letterRack.removeLetters(toRemove);
        Assertions.assertNull(letterRack.getLETTERS()[removedIndex]);

        //Testing rackIsNotFull
        Assertions.assertTrue(letterRack.rackNotFull());

        //Testing refill
        letterRack.refill();
        for(Tile tile: letterRack.getLETTERS()){
            Assertions.assertNotNull(tile);
        }

    }

    /**
     * Test expected outcome: letterRack does not change
     */
    @Test
    public void refillWhileFull(){
        //instantiating needed objects
        LetterRack letterRack = new LetterRack(new Bag());
        Tile[] tileArray = letterRack.getLETTERS();
        Random rand = new Random();
        rand.setSeed(0);

        letterRack.refill();

        int index = 0;
        for (Tile eachTile: letterRack.getLETTERS()){
            Assertions.assertEquals(tileArray[index].getLetter().charAt(0), eachTile.getLetter().charAt(0));
            index++;
        }
    }
}
