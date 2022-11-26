package core_entities.game_parts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;


/**
     This class reads the dictionary.txt file and imports it as a searchable file for use to confirm
     words with verify_word for validity to place on board.
     Currently, its ATTRIBUTES are:

     ArrayList<String> longDictionary = list of all scrabble valid words

     HashMap<Set<Character>, ArrayList<String>> characterSetDictionary = a dictionary that takes in a set of letters and returns an arraylist
     of all the valid words in scrabble that can be made from them.

     To utilize this function, you do not need to enter a set of characters,
     it converts it automatically!

     So simple provide a String to the getter for example;
     getCharacterSetDictionary("skhuo")
     and it will return a list of strings,
     sorted by length then alphabetical as Arraylist<String>

     This class @Overrides compare in this function alone via a Lambda.
*/


public class Dictionary implements Serializable {

    private final ArrayList<String> longDictionary;

    public Dictionary(ArrayList<String> longDictionary) {

        this.longDictionary = longDictionary;
        charSetDictionary();
    }
    private static HashMap<Set<Character>, ArrayList<String>> characterSetDictionary = new HashMap<>();
    {
        characterSetDictionary = charSetDictionary();
    }




    private HashMap<Set<Character>, ArrayList<String>> charSetDictionary(){
        HashMap<Set<Character>, ArrayList<String>> setDict = new HashMap<>();
        ArrayList<String> list;

        for (String s: this.longDictionary) {
            if(setDict.containsKey(strToSet(s))){
                list = setDict.get(strToSet(s));
                list.add(s);}
            else {
                list = new ArrayList<>();
                list.add(s);
                setDict.put(strToSet(s), list);}
            }

        return setDict;
    }

    /**
     * This function stakes in a string value and converts it to a set of characters
     * @param str is a String with no spaces or symbols please.
     * @return a set of characters
     */
    public static Set<Character> strToSet(String str) {
        Set<Character> set;

        if (str == null) {
            return new HashSet<>();
        }
        set = new HashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }

    /**
     * This getter function is used to return specific ArrayList of all words in the
     * Scrabble Dictionary that can be made from the String parameter submitted. It does this by converting the
     * paramater to a set of its characters. Example, if you submit a string of 'aaabbb' it is converted to
     * set{'a', 'b'} and will return a list of words composed of just those two letters.
     * @param str <String></String>
     * @return ArrayList<String></String>
     */

    public static ArrayList<String> getCharacterSetDictionary(String str){
        ArrayList<String> list;
        list = characterSetDictionary.get(strToSet(str));
        list.sort((o1, o2) -> 0);
        return list;
    }

}
