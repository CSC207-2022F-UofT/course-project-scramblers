package core_entities.game_parts;

import CoreEntities.GameParts.Square;
import CoreEntities.GameParts.Tile;
import java.io.Serializable;

public class DefaultBoard implements Serializable, Board{
    private final Square[][] grid;
    public DefaultBoard () {
        this.grid = generateDefaultGrid();
    }
    public Square [][] getGrid() {
        return this.grid;
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
     * @param c1 Coordinate object indicating the start of the word
     * @param c2 Coordinate indicating the end of the word
     */
    public void placeTiles(Tile[] tileList, Coordinate c1, Coordinate c2) {
        boolean horizontal = c1.getXCoordinate() < c2.getXCoordinate();
        int initialXCoordinate = c1.getXCoordinate();
        int initialYCoordinate = c1.getYCoordinate();
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
