package CoreEntities.GameParts;

public class Tile {
    private final String letter;
    private final int value;

    public Tile(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }
}
