package core_entities.game_parts;

import CoreEntities.GameParts.Square;
import CoreEntities.GameParts.Tile;

public interface Board{
    void setGrid(Square [][] newGrid);
    void placeTiles(Tile[] tileList, int [] startCoordinates, int [] endCoordinates);
}
