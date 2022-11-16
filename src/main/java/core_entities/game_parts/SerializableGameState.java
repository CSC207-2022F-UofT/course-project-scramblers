package core_entities.game_parts;

import core_entities.Player.Player;

import java.io.Serializable;

public class SerializableGameState implements Serializable {
    private Player p1;
    private Player p2;
    private Board board;

    public SerializableGameState(Player p1, Player p2, Board b) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = b;
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
}
