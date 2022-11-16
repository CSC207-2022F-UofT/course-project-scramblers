package CoreEntities.Player;

import core_entities.game_parts.LetterRack;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    @Override
    boolean makeMove(String word, int start_x, int end_x, int start_y, int end_y){return false;}

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }
}
