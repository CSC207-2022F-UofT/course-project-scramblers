package core_entities.player;


import core_entities.game_parts.LetterRack;

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
    boolean makeMove(String word, int start_x, int end_x, int start_y, int end_y) {
        // If word is verified, place word on board
            // word is verified if it is a valid word in dictionary and
            // if there's space for it on the board.
            // return true.
        // If not, return false.
        return false;
    }

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {
        // iterate through Player's letter rack.
        // If tile in LETTERS is in toReplaceValues, delete that char
        // after iterating through the letter rack, iterate through
        // newValues and for each char in newValues, add it to letter rack.
    }
}

