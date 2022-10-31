package CoreEntities.Player;

import CoreEntities.GameParts.LetterRack;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    @Override
    boolean makeMove(String word) {
        return false;
    }

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }
}
