package use_cases.take_turn;

import core_entities.game_parts.Coordinate;

public class TakeTrunInputData {

    private final String word;
    private final Coordinate start;
    private final Coordinate end;

    public TakeTrunInputData(String word, Coordinate start, Coordinate end) {
        this.word = word;
        this.start = start;
        this.end = end;

    }

    public String getWord(){return this.word;}
    public Coordinate getStart(){return this.start;}
    public Coordinate getEnd(){return this.end;}
}
