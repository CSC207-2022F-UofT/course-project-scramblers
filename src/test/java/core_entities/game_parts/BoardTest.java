package core_entities.game_parts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board;
    BoardFactory factory;
    @BeforeEach
    public void setup() {
        String [][] multipliers = new String [15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                multipliers[i][j] = "*";
            }
        }
        factory = new DefaultBoardFactory();
        board = factory.create(multipliers);
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