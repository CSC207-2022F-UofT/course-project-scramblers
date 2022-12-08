package use_cases.reload_game_use_case;

import core_entities.player.Player;
import core_entities.game_parts.Board;

public class ReloadGameDsResponseModel {

    private final Player p1;
    private final Player p2;
    private final Board board;

    /**
     * Data store object which holds information obtained from a previous version of GameState
     * @param p1 Player
     * @param p2 Player
     * @param board Board
     */
    public ReloadGameDsResponseModel(Player p1, Player p2, Board board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
    }

    public Player getP1() {
        return p1;
    }


    public Player getP2() {
        return p2;
    }


    public Board getBoard() {
        return board;
    }

}
