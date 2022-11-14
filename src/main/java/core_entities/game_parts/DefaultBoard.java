package core_entities.game_parts;

import CoreEntities.GameParts.Square;
import CoreEntities.GameParts.Tile;
import java.io.Serializable;
import java.util.HashMap;

public class DefaultBoard implements Serializable, Board{
    private Square[][] grid;
    private final HashMap<Square, Coordinate[]> tilePlacement = new HashMap();
    public DefaultBoard () {
        this.grid = generateDefaultGrid();
    }
    public Square [][] getGrid() {
        return this.grid;
    }
    public void setGrid(Square [][] newGrid) {
        this.grid = newGrid;
    }
    /**
     * @return The default grid of a Scrabble Game, of size DEFUALT_BOARD_SIZE
     */
    private Square [][] generateDefaultGrid() {
        //TODO: Add multipliers
        int DEFAULT_BOARD_SIZE = 15;
        Square [][] grid = new Square[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                grid[i][j] = new Square("");
            }
        }
        return grid;
    }
    /**
     * Preconditions: startCoordinates and endCoordinates are arrays of the form [x, y]
     * Postconditions: The word is placed on the board
     * @param tileList A list of tiles that needs to be placed
     * @param startCoordinates Array indicating start position of the word
     * @param endCoordinates Array indicating end position of the word
     */
    public void placeTiles(Tile[] tileList, int [] startCoordinates, int [] endCoordinates) {
        boolean horizontal = startCoordinates[0] < endCoordinates[0];
        int initialXCoordinate = startCoordinates[0];
        int initialYCoordinate = startCoordinates[1];
        for (int i = 0; i < tileList.length; i++) {
            if (horizontal) {
                this.grid[initialXCoordinate + i][initialYCoordinate].setTile(tileList[i]);
            }
            else {
                this.grid[initialXCoordinate][initialYCoordinate + i].setTile(tileList[i]);
            }
        }
    }
}
