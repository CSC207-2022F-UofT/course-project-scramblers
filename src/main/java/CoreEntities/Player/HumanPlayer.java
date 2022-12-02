package CoreEntities.Player;


import core_entities.game_parts.Dictionary;
import core_entities.game_parts.LetterRack;

import java.util.ArrayList;
import java.util.Objects;

public class HumanPlayer extends Player {

    private static int tries = 0;
    public HumanPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    /**
     *
     * @param word
     * @return true if word is in dictionary. Otherwise, return false.
     */
    // check to see if word is in dictionary
    // Dictionary.getCharacterSetDictionary returns an array list of
    // all words in dictionary containing the letters in a str
    // if word in result, return true
    // else, return false
    public boolean chooseWord(String word) {
        ArrayList<String> availableWords = Dictionary.getCharacterSetDictionary(word);
        for (int i = 0; i < availableWords.toArray().length; i++) {
            if (Objects.equals(word, availableWords.get(i))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    // Option a) Exchange Letters -> Jos
    //           - Player has to use option a if tries = 3
    // Option b) Player makes move
    // i. Player chooses a valid word - chooseWord
    // ii. Player chooses a valid space on board --> Hrid
    //     - run update_tries. If tries = 3, Player goes to Option a
    // iii. Update LetterRack -> Jos
    // iv. Change_turn to next Player -> Ethan
    @Override
    boolean makeMove(String word, int start_x, int end_y) {

        return false;
    }


    // Remove Replace Letters after updating Player Abstract Class
    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }


}


