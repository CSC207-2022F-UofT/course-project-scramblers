package core_entities.game_parts;

import java.io.Serializable;

public class Tile implements Serializable {
    /**
     * Class representing a letter tile of the game
     */
    private final char letter;
    private final int value;

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    /**
     * Get the char of the letter of this tile.
      * @return char of the letter of this tile
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Get the value of the letter of this tile.
     * @return value of the letter of this tile.
     */
    public int getValue() {
        return value;
    }
}
