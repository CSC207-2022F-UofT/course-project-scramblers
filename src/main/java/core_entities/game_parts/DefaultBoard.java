package core_entities.game_parts;

import java.io.Serializable;

public class DefaultBoard implements Serializable, Board{
    private final Square[][] grid;
    private final int DEFAULT_BOARD_SIZE;
    public DefaultBoard (String [][] multipliers) {
        this.DEFAULT_BOARD_SIZE = 15;
        this.grid = generateDefaultGrid(multipliers);
    }
    public Square [][] getGrid() {
        return this.grid;
    }
    /**
     * @return The default grid of a Scrabble Game, of size DEFUALT_BOARD_SIZE
     */
    private Square [][] generateDefaultGrid(String [][] multipliers) {
        Square [][] grid = new Square[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                grid[i][j] = new Square(multipliers[i][j]);
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
    public String [][] getMultiplierGrid() {
        String [][] multiplierGrid = new String [DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                multiplierGrid[i][j] = this.grid[i][j].getMultiplier();
            }
        }
        return multiplierGrid;
    }
    public char [][] getLetterGrid() {
        char [][] letterGrid = new char [DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
        for (int i = 0; i < DEFAULT_BOARD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_BOARD_SIZE; j++) {
                letterGrid[i][j] = this.grid[i][j].getTile().getLetter();
            }
        }
        return letterGrid;
    }
}
