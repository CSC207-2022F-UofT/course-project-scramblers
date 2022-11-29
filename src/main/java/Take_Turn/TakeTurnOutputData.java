package Take_Turn;

import core_entities.game_parts.Coordinate;
import core_entities.game_parts.LetterRack;

public class TakeTurnOutputData {

    String wordplaced;
    LetterRack rack;
    Coordinate start;
    Coordinate end;

    public TakeTurnOutputData(String wordplaced, LetterRack rack, Coordinate start, Coordinate end){
        this.wordplaced = wordplaced;
        this.rack = rack;
        this.start = start;
        this.end = end;
    }
}
