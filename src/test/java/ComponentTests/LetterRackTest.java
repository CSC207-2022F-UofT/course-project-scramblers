package ComponentTests;

import CoreEntities.GameParts.Bag;
import CoreEntities.GameParts.LetterRack;
import CoreEntities.GameParts.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LetterRackTest {

    @Test
    void generalCase() {
        Bag bag = new Bag();
        LetterRack letterRack = new LetterRack(bag);
        Tile[] tileArray = letterRack.getLETTERS();

        //Testing removeLetters
        //Testing rackIsNotFull
        //Testing refill
    }
}
