package CoreEntities.GameParts;

import CoreEntities.Player.HumanPlayer;
import CoreEntities.Player.Player;
import CoreEntities.Player.ComputerPlayer;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class BoardTest {

    Bag bag;
    LetterRack rackOne;
    LetterRack rackTwo;
    Player p1;
    Player p2;
    Board board;
    @Before
    public void setup() throws Exception {
        bag = new Bag();
        //Add bag as parameter
        rackOne = new LetterRack();
        rackTwo = new LetterRack();
        p1 = new HumanPlayer("Ethan", rackOne, 0);
        p2 = new ComputerPlayer("BeepBoop", rackTwo, 0);
        board = new Board (p1, p2);
    }
    @Test
    void placeTilesTest() {
        Tile [] tileList = new Tile[5];
        int [] startCoordinates = new int [] {1, 2};
        int [] endCoordinates = new int [] {1, 6};
        for (int i = 0; i < 5; i++) {
            tileList[i] = new Tile("a", i);
        }
        board.placeTiles(tileList, startCoordinates, endCoordinates);
        assert("a".equals(board.getGrid()[1][2].getTile().getLetter()));
    }
}