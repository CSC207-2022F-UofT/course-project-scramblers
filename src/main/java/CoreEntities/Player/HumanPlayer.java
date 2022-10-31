package CoreEntities.Player;

import CoreEntities.GameParts.LetterRack;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    /**
     *
     * @param word
     * @return true iff and only if word was placed on board. Word is
     * placed on board if the move is valid.
     */
    @Override
    boolean makeMove(String word) {

        

        // If word is verified, place word on board
            // word is verified if it is a valid word in dictionary and
            // if there's space for it on the board.
            // return true.
        // If not, return false.
        return false;
    }

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }
}

