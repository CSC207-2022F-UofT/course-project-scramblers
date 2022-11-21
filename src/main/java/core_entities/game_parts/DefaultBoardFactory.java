package core_entities.game_parts;

public class DefaultBoardFactory implements BoardFactory{
    public Board create(String [][] multipliers) {
        return new DefaultBoard(multipliers);
    }
}
