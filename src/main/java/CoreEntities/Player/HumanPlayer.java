package CoreEntities.Player;


import core_entities.game_parts.LetterRack;

public class HumanPlayer extends Player {

    private static int tries = 0;
    public HumanPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    /**
     *
     * @param word
     * @return true if word is in dictionary. Otherwise, return
     * a str, telling Player to try again.
     */
    public chooseWord(String word) {
        // body here.
    }


    // Option a) Exchange Letters -> Jos
    //           - Player has to use option a if tries = 3
    // Option b) Player makes move
    //
    @Override
    boolean makeMove(String word, int start_x, int end_y) {

        return false;
    }


    // Remove Replace Letters after updating Player Abstract Class
    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }


}


