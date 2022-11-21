package use_cases.reload_game_use_case;

import CoreEntities.Player.Player;
import core_entities.game_parts.Board;

public class ReloadGameDsResponseModel {

    private Player p1;
    private Player p2;
    private Board board;

    public ReloadGameDsResponseModel(Player p1, Player p2, Board board) {
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
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

    public void setBoard(Board board) {
        this.board = board;
    }
}
