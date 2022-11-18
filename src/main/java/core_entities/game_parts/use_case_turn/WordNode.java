package core_entities.game_parts.use_case_turn;

abstract class WordNode {
    String wordNodeValue = null;
    Boolean wordOrientation;
    WordNode previousWord = null;
    abstract void setWordNodeValue();

    abstract void setWordOrientation();

    abstract boolean isLast();

    abstract WordNode nextWord();

}
