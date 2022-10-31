package core.game_parts;

public class Tile {
    private final String letter;
    private final int value;

    public Tile(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public char getLetter() {
        return letter.charAt(0);
    }

    public int getValue() {
        return value;
    }
}
