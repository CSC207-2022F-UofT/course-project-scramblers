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
     * Constructor that deteremines the value based on the inputted letter
     */
    public Tile(char letter){
        this.letter = letter;
        this.value = determineTileValue(letter);
    }


    private int determineTileValue(char letter) {
        if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O'
                || letter == 'U' || letter == 'L' || letter == 'N' || letter == 'S'
                || letter == 'T'  || letter == 'R'){
            return 1;
        }
        else if (letter == 'D' || letter == 'G'){
            return 2;
        }
        else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P'){
            return 3;
        }
        else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W'
                || letter == 'Y'){
            return 4;
        }
        else if (letter == 'K'){
            return 5;
        }
        else if (letter == 'J' || letter == 'X'){
            return 8;
        }
        else {
            return 10;
        }
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
