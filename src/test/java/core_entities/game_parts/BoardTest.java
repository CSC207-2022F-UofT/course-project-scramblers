package core_entities.game_parts;

import CoreEntities.GameParts.Tile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board;
    BoardFactory factory;
    @BeforeEach
    public void setup() {
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
        for (int i = 2; i <= 6; i++) {
            assert ('a' == board.getGrid()[1][i].getTile().getLetter());
        }
    }
}