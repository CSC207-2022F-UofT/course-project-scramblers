package core_entities.game_parts;

import java.io.Serializable;

public class Square implements Serializable {
    private final String multiplier;
    private Tile tile;

    public Square (String multiplier, Tile tile) {
        this.multiplier = multiplier;
        this.tile = tile;
    }
    public Square (String multiplier) {
        this.multiplier = multiplier;
        this.tile = new Tile(' ');
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
