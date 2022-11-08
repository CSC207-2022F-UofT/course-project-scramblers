package CoreEntities.GameParts;

import CoreEntities.Player.Player;
import java.io.Serializable;

public class Board implements Serializable{
    private final Player p1;
    private final Player p2;
    private Square [][] grid;
    public Board (Player p1, Player p2, Square [][] grid) {
        this.p1 = p1;
        this.p2 = p2;
        this.grid = grid;
    }
    /**
     * Creates a new Board Object with two Players and the default board
     * @param p1 The first Player of the game
     * @param p2 The second Player of the game
     */
    public Board (Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.grid = generateDefaultGrid();
    }
    public Player getP1() {
        return this.p1;
    }
    public Player getP2() {
        return this.p2;
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
     * @param startCoordinates Array indicating start position of the word
     * @param endCoordinates Array indicating end position of the word
     */
    public void placeTiles(Tile [] tileList, int [] startCoordinates, int [] endCoordinates) {
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
