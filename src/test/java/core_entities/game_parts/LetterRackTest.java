package core_entities.game_parts;

import CoreEntities.GameParts.Bag;
import CoreEntities.GameParts.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

class LetterRackTest {

    LetterRack letterRack;
    Tile[] tileArray;
    Random rand;

    @BeforeEach
    public void init(){
        //instantiating needed objects
        letterRack = new LetterRack(new Bag(), 7);
        tileArray = letterRack.getLETTERS();
        rand = new Random();
        rand.setSeed(0);
    }

    @Test
    public void GeneralCase() {

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

        letterRack.refill();

        int index = 0;
        for (Tile eachTile: letterRack.getLETTERS()){
            Assertions.assertEquals(tileArray[index].getLetter().charAt(0), eachTile.getLetter().charAt(0));
            index++;
        }
    }
}
