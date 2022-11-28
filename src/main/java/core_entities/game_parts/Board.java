package core_entities.game_parts;

public interface Board {
    Square [][] getGrid();
    void placeTiles(Tile[] tileList, Coordinate c1, Coordinate c2);
    String [][] getMultiplierGrid();
    char [][] getLetterGrid();
}
