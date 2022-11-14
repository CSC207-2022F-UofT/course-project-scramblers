package core_entities.game_parts;

import CoreEntities.GameParts.Square;
import CoreEntities.GameParts.Tile;

public interface Board{
    Square [][] getGrid();
    void placeTiles(Tile[] tileList, Coordinate c1, Coordinate c2);
}
