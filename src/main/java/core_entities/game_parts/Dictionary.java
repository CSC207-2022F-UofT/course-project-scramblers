package core_entities.game_parts;

import CoreEntities.IO.DictionaryDataReaderGateway;

import java.io.FileNotFoundException;
import java.util.*;


/**
     This class reads the dictionary.txt file and imports it as a searchable file for use to confirm
     words with verify_word for validity to place on board.
     Currently, its ATTRIBUTES are:

     ArrayList<String> longDictionary = list of all scrabble valid words

     HashMap<Set<Character>, ArrayList<String>> characterSetDictionary = a
    dictionary that takes in a set of letters and returns an arraylist
     of all the valid words in scrabble that can be made from them.

     To utilize this function, you do not need to enter a set of characters,
     it converts it automatically!

     So simple provide a String to the getter for example;
     getCharacterSetDictionary("skhuo")
     and it will return a list of strings,
     sorted by length then alphabetical as Arraylist<String>

     This class @Overrides compare in this function alone via a Lambda.
*/



public class Dictionary implements DictionaryFunctions {

        private ArrayList<String> longDictionary;
        private HashMap<Set<Character>, ArrayList<String>> characterSetDictionary;

        public Dictionary(ArrayList<String> readerList) throws FileNotFoundException {
            this.longDictionary = readerList;
            this.characterSetDictionary = charSetDictionary();
        }




    /**
     * This method builds a hashmap of sets of characters as keys and lists of the words
     * they can make up as their contents. It takes in a string as a parameter and returns
     * an arraylist of strings.
     * @param str the string to be converted to a set of characters
     * @return ArrayList<String>
     */


    private HashMap<Set<Character>, ArrayList<String>> charSetDictionary(){
        HashMap<Set<Character>, ArrayList<String>> setDict = new HashMap<>();


        for (String s: longDictionary) {
            ArrayList<String> list;
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
     * This function stakes in a string value and converts it to a set of characters and returns it.
     * @param str is a String with no spaces or symbols please.
     * @return a set of characters
     */
    public Set<Character> strToSet(String str) {
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
     * This function is used to return specific ArrayList of all words in the
     * Scrabble Dictionary that can be made from the String parameter submitted. It does this by converting the
     * parameter to a set of its characters. Example, if you submit a string of 'aaabbb' it is converted to
     * set{'a', 'b'} and will return a list of words composed of just those two letters.
     * Precondition: The string must be all uppercase letters and no spaces or symbols.
     * @param str is an all uppercase String with no spaces or symbols please.
     * @return ArrayList<String></String>
     */

    public ArrayList<String> getSingleCharacterSetDictionary(String str){
        ArrayList<String> list;
        list = characterSetDictionary.get(strToSet(str));
//        list.sort((o1, o2) -> 0);
        return list;
    }

    /**
     * This function is used to combine different combinations of letters into all possible sets
     * greater than 2 characters long. It then returns a list of all the words that can be made from
     * them, and combines the lists into one list.

     * @param str is an all uppercase String with no spaces or symbols please.
     * @return ArrayList<String></String>
     */
    public ArrayList<String> getCharacterSetDictionary(String str) {
        ArrayList<String> list;
        list = getSingleCharacterSetDictionary(str);

        int length = str.length();
        while (length / 2 >= 2) {
            list.addAll(getSingleCharacterSetDictionary(str.substring(0, length / 2)));
            list.addAll(getSingleCharacterSetDictionary(str.substring(length / 2, length)));
            length = length / 2;
        }
        list.sort((o1, o2) -> 0);
        return list;
    }

    /**
     * This getter function is used to return an entire HashMap of the
     * Scrabble Dictionary.  The key is a set of characters and the value is an ArrayList of all the words.
     * @return HashMap<Set<Character>, ArrayList<String>>
     */

    public HashMap<Set<Character>, ArrayList<String>> getDictionaryMap() {
        return characterSetDictionary;
    }

    /**
     * This getter function is used to return an entire ArrayList of the dictionary.
     * @return ArrayList<String> of all words in the dictionary.
     */

    public ArrayList<String> getDictionaryFile() {
        return longDictionary;
    }

    /**
     * This function is used to verify that a word is in the dictionary.
     * @param word is a String with no spaces or Symbols please. in UpperCase.
     * @return boolean true if the word is in the dictionary, false if not.
     */
    public boolean verifyWord(String word) {
        return longDictionary.contains(word);

    }



}
