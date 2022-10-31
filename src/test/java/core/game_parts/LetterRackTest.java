package core.game_parts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class LetterRackTest {

    @Test
    public void GeneralCase() {
        //instantiating needed objects
        Bag bag = new Bag();
        LetterRack letterRack = new LetterRack(bag);
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
}
