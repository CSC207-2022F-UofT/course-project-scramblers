package core_entities.game_parts.board;

import core_entities.game_parts.Coordinate;
import core_entities.game_parts.Square;
import core_entities.game_parts.Tile;

public interface Board{
    Square[][] getGrid();
    void placeTiles(Tile[] tileList, Coordinate c1, Coordinate c2);
    String [][] getMultiplierGrid();
    char [][] getLetterGrid();
}
