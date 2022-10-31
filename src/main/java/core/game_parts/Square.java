package core.game_parts;

public class Square {
    private final String multiplier;
    private Tile tile;

    public Square (String multiplier, Tile tile) {
        this.multiplier = multiplier;
        this.tile = tile;
    }
    public Square (String multiplier) {
        this.multiplier = multiplier;
        this.tile = null;
    }
    public void setTile(Tile newTile) {
        this.tile = newTile;
    }
    public Tile getTile() {
        return this.tile;
    }
    public String getMultiplier() {
        return this.multiplier;
    }
}
