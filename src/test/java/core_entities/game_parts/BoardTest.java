package core_entities.game_parts;

import CoreEntities.GameParts.Bag;
import CoreEntities.GameParts.Tile;
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
        rackOne = new LetterRack(bag, 7);
        rackTwo = new LetterRack(bag, 7);
        p1 = new HumanPlayer("Ethan", rackOne, 0);
        p2 = new ComputerPlayer("BeepBoop", rackTwo, 0);
        board = new DefaultBoard ();
    }
    @Test
    void placeTilesTest() {
        Tile[] tileList = new Tile[5];
        int [] startCoordinates = new int [] {1, 2};
        int [] endCoordinates = new int [] {1, 6};
        for (int i = 0; i < 5; i++) {
            tileList[i] = new Tile('a', i);
        }
        board.placeTiles(tileList, startCoordinates, endCoordinates);
        assert('a' == board.getGrid()[1][2].getTile().getLetter());
    }
}