package core_entities.game_parts;

import core_entities.player.Player;

import java.io.Serializable;

public class SerializableGameState implements Serializable {
    private Player p1;
    private Player p2;
    private Board board;
    private int currentTurn;
    private Dictionary dict;

    public SerializableGameState(Player p1, Player p2, Board b, int currentTurn, Dictionary dict) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = b;
        this.currentTurn = currentTurn;
        this.dict = dict;
    }
    public Player getP1() {
        return p1;
    }
    public void setP1(Player p1) {
        this.p1 = p1;
    }
    public Player getP2() {
        return p2;
    }
    public void setP2(Player p2) {
        this.p2 = p2;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board b) {
        this.board = b;
    }
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }
    public int getCurrentTurn() {
        return this.currentTurn;
    }
    public void setDict(Dictionary dict) {
        this.dict = dict;
    }
    public Dictionary getDict() {
        return this.dict;
    }
}
