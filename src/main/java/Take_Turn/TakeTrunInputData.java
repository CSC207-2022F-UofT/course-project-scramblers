package Take_Turn;

import CoreEntities.Player.Player;
import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;

public class TakeTrunInputData {

    private final String word;
    private final Coordinate start;
    private final Coordinate end;
    private final Player currplayer;
    private final GameState gameState;

    public TakeTrunInputData(String word, Coordinate start, Coordinate end, Player currplayer, GameState gameState) {
        this.word = word;
        this.start = start;
        this.end = end;
        this.currplayer = currplayer;
        this.gameState = gameState;
    }

    public String getWord(){return this.word;}
    public Coordinate getStart(){return this.start;}
    public Coordinate getEnd(){return this.end;}
    public Player getCurrplayer(){return this.currplayer;}
    public GameState getGameState(){return this.gameState;}
}
