package core_entities.game_parts.board;

public class DefaultBoardFactory implements BoardFactory{
    public Board create(String [][] multipliers) {
        return new DefaultBoard(multipliers);
    }
}
