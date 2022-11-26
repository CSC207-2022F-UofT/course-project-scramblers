package core_entities.game_parts;

import core_entities.game_parts.board.Board;
import core_entities.player.Player;

public class GameState {
    private static Player p1;
    private static Player p2;
    private static Board board;
    public static Player getP1() {
        return GameState.p1;
    }
    public static void setP1(Player p1) {
        GameState.p1 = p1;
    }
    public static Player getP2() {
        return GameState.p2;
    }
    public static void setP2(Player p2) {
        GameState.p2 = p2;
    }
    public static Board getBoard() {
        return GameState.board;
    }
    public static void setBoard(Board b) {
        GameState.board = b;
    }
    public static SerializableGameState generateSerializableGameState() {
        return new SerializableGameState(GameState.p1, GameState.p2, GameState.board);
    }
}
