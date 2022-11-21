package CoreEntities.Player;

import core_entities.game_parts.LetterRack;

import java.io.Serializable;

public abstract class Player implements Serializable{

    protected String name;
    protected LetterRack rack;
    protected int score;

    /**
     * Creating an object of type Player, which has a name, a letter rack, and a score
     * @param name The name of the player. Used to identify the turn
     * @param rack The rack which holds the player's available letters
     * @param score The player's current score
     */
    public Player(String name, LetterRack rack, int score) {
        this.name = name;
        this.rack = rack;
        this.score = score;
    }
   
    abstract boolean makeMove(String word, int start_x, int end_x, int start_y, int end_y);

    public int getScore() {
        return this.score;
    }

    public void addScore(int num) {
        this.score = this.score + num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
