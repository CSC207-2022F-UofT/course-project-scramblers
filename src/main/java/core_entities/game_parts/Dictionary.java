package CoreEntities.GameParts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// This class reads the dictionary.txt file and imports it as a searchable file for use to confirm
// words with verify_word for validity to place on board.
// Currently its ATTRIBUTES are:
//
// ArrayList<String> longDictionary = list of all scrabble valid words
//
// HashMap<Set<Character>, ArrayList<String>> characterSetDictionary = a dictionary that takes in a set of letters and returns an arraylist
// of all the valid words in scrabble that can be made from them.
//
// To utilize this function, you do not need to enter a set of characters,
// it converts it automatically!
//
// So simple provide a String to the getter for example;
// getCharacterSetDictionary("skhuo")
// and it will return a list of strings,
// sorted by length then alphabetical as Arraylist<String>
//
// This class @Overrides compare in this function alone via a Lambda.



public class Dictionary {

    private ArrayList<String> longDictionary;

    private HashMap<Set<Character>, ArrayList<String>> characterSetDictionary;

    public Dictionary() throws FileNotFoundException {
        myDictionaryReader();
        charSetDictionary();
    }

    public void myDictionaryReader() throws FileNotFoundException {

        Scanner s = new Scanner(new File("src/resources/scrabble_dictionary.txt"));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        this.longDictionary = list;


    }
    public void charSetDictionary(){
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
        this.characterSetDictionary = setDict;
    }
    private static Set<Character> strToSet(final String str) {
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


    public ArrayList<String> getCharacterSetDictionary(String s){
        ArrayList<String> list;
        list = characterSetDictionary.get(strToSet(s));
        Collections.sort(list, (o1, o2) -> 0);
        return list;
    }
}
