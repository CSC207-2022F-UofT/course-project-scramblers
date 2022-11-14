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
    BoardFactory factory;
    @Before
    public void setup() throws Exception {
        bag = new Bag();
        rackOne = new LetterRack(bag, 7);
        rackTwo = new LetterRack(bag, 7);
        p1 = new HumanPlayer("Ethan", rackOne, 0);
        p2 = new ComputerPlayer("BeepBoop", rackTwo, 0);
        factory = new DefaultBoardFactory();
        board = factory.create();
    }
    @Test
    void placeTilesTest() {
        Tile[] tileList = new Tile[5];
        Coordinate c1 = new Coordinate(1, 2);
        Coordinate c2 = new Coordinate(1, 6);
        for (int i = 0; i < 5; i++) {
            tileList[i] = new Tile('a', i);
        }
        board.placeTiles(tileList, c1, c2);
        assert('a' == board.getGrid()[1][2].getTile().getLetter());
    }
}