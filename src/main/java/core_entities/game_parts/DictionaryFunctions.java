package core_entities.game_parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public interface DictionaryFunctions {


    /**
     * This method takes in a string of a word, converts it to a set of characters, then
     * returns an ArrayList of all the words in the dictionary that can be made from the
     * sets. It combines all sets of characters greater than two characters long.
     * @return ArrayList<String>
     */
    ArrayList<String> getCharacterSetDictionary(String str);


    /**
     * This method returns the entire dictionary as an ArrayList of Strings
     */
    ArrayList<String> getDictionaryFile();

    /**
     * This method returns the boolean value of true if the word is valid and in the dictionary
     */

    boolean verifyWord(String word);

    /**
     * This method returns the entire dictionary as a HashMap of Sets of Characters and ArrayLists of Strings
     */
    HashMap<Set<Character>, ArrayList<String>> getDictionaryMap();
}