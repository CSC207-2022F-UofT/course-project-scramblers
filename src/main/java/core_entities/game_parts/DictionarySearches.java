package core_entities.game_parts;

import java.util.ArrayList;

public class DictionarySearches{

    public ArrayList<String> searchlist;

    public DictionarySearches(String search) {
        this.searchlist = Dictionary.getCharacterSetDictionary(search);
    }

    protected  ArrayList<String> getLengthIndexChar(int length, int index, char letter){
        ArrayList<String> search;
        search = Dictionary.getCharacterSetDictionary(str);

        return search;
    }

    public ArrayList<String> findLength(int length){
        ArrayList<String> hold = null;
        for(String str :this.searchlist){
            if (str.length() == length){
                assert hold != null;
                hold.add(str);
            }
        }
        return hold;
    }

    public ArrayList<String> findIndexChar(char character){
        return null;
    }
}

