package CoreEntities.GameParts;

import CoreEntities.Player.HumanPlayer;
import CoreEntities.Player.Player;
import CoreEntities.Player.ComputerPlayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void boardCreation() {
        //Add this to a @Before (not sure how)
        Bag bag = new Bag();
        //Add bag as parameter
        LetterRack rackOne = new LetterRack();
        LetterRack rackTwo = new LetterRack();
        Player p1 = new HumanPlayer("Ethan", rackOne, 0);
        Player p2 = new ComputerPlayer("BeepBoop", rackTwo, 0);
        Board board = new Board(p1, p2);
    }
}