package core_entities.game_parts;

import CoreEntities.GameParts.*;
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
        tileArray = letterRack.getLetters();
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
        Assertions.assertNull(letterRack.getLetters()[removedIndex]);

        //Testing rackIsNotFull
        Assertions.assertTrue(letterRack.rackNotFull());

        //Testing refill
        letterRack.refill();
        for(Tile tile: letterRack.getLetters()){
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
        for (Tile eachTile: letterRack.getLetters()){
            Assertions.assertEquals(tileArray[index].getLetter(), eachTile.getLetter());
            index++;
        }
    }

    @Test
    public void changeRackLength(){
        int newLength = letterRack.getLetters().length + 2;
        letterRack.changeRackLength(newLength);
        Assertions.assertEquals(newLength, letterRack.getLetters().length);
    }
}
