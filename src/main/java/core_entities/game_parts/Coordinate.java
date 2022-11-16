package core_entities.game_parts;

public class Coordinate {
    private int xCoordinate;
    private int yCoordinate;

    public Coordinate(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    public int getXCoordinate() {
        return this.xCoordinate;
    }
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public int getYCoordinate() {
        return this.yCoordinate;
    }
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
