package core_entities.game_parts;

public class DefaultBoardFactory implements BoardFactory{
    public Board create() {
        return new DefaultBoard();
    }
}
