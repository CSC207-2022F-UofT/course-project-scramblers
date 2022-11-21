package core_entities.game_parts;

import java.util.ArrayList;

/**
 * This class creates a new refined searchable object from the Dictionary class that returns lists of strings
 * for set searches or returns null if no such list can be created.
 *
 */

public class DictionarySearches {

    public ArrayList<String> searchList;

    public DictionarySearches(String search) {

        this.searchList = Dictionary.getCharacterSetDictionary(search);
    }


    public ArrayList<String> getLengthIndexChar(int length, int index, char letter){
        ArrayList<String> searched;
        ArrayList<String> charSearch = new ArrayList<>();
        searched = findLength(length);
        for(String str: searched){
            if(str.charAt(index)==letter) {
                charSearch.add(str);
            }}
            return charSearch;

            }//finished fixing the brackets - Joseph S



    public ArrayList<String> findLength(int len){
            ArrayList<String> hold =new ArrayList<>();
        for(String str :this.searchList) {
            if (str.length() == len) {
                hold.add(str);
            }
        }
            return hold;
        }

}

