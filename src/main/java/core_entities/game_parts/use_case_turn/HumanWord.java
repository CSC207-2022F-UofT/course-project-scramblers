package core_entities.game_parts.use_case_turn;

public class HumanWord extends WordNode{
    @Override
    void setWordNodeValue() {

    }

    @Override
    void setWordOrientation() {

    }

    @Override
    boolean isLast() {
        return false;
    }

    @Override
    WordNode nextWord() {
        return null;
    }
}
