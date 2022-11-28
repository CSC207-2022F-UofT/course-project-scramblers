package Computer_player_place_word_user_story;

import core_entities.game_parts.Board;
import core_entities.game_parts.GameState;
import core_entities.game_parts.LetterRack;

public class ComPlaceWordInputData {

    private final String name;

    private final LetterRack rack;

    private int score;

    private Board currBoard;

    public ComPlaceWordInputData(String name, LetterRack rack, int score){
        this.name = name;
        this.rack = rack;
        this.score = score;
        this.currBoard = GameState.getBoard();
    }

    public String getName(){return this.name;}
    public LetterRack getRack(){return this.rack;}
    public int getScore(){return this.score;}
    public Board getCurrBoard(){return this.currBoard;}
}

