package core_entities.game_parts;

import CoreEntities.Player.Player;

import java.io.Serializable;

public class GameState implements Serializable {
    private static Player p1;
    private static Player p2;
    private static Board board;

    private GameState(Player p1, Player p2, Board b) {
        GameState.p1 = p1;
        GameState.p2 = p2;
        GameState.board = b;
    }

    public GameState() {

    }
    public Player getP1() {
        return GameState.p1;
    }
    public void setP1(Player p1) {
        GameState.p1 = p1;
    }
    public Player getP2() {
        return GameState.p2;
    }
    public void setP2(Player p2) {
        GameState.p2 = p2;
    }
    public Board getBoard() {
        return GameState.board;
    }
    public void setBoard(Board b) {
        GameState.board = b;
    }
    public SerializableGameState generateSerializableGameState() {
        return new SerializableGameState(GameState.p1, GameState.p2, GameState.board);
    }
}
