package core_entities.game_parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public interface DictionaryFunctions {

    /**
     * This method returns the entire dictionary as an ArrayList of Strings
     */
    public ArrayList<String> getDictionaryFile();

    /**
     * This method returns the boolean value of true if the word is valid and in the dictionary
     */

    public boolean verifyWord(String word);

    public HashMap<Set<Character>, ArrayList<String>> getDictionaryMap();
}