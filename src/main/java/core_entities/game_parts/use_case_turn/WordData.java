package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordData {
    Arraylist<int> firstCoordinate;
    ArrayList<int> secondCoordinate;

    public WordData(String word,int first, int second, int hOrV) {
        ArrayList wordValue = null;
        int start;
        int constant;
        if (hOrV==0){
            start = second;
            constant=first;}
        else {
            start=first;
            constant=second;
        }
        ArrayList<Character> wordChars = (ArrayList<Character>) strToList(word);
        for(int i = 0; i <= wordChars.size(); i++){

            int myChar = wordChars.get(i) +0;
            wordValue.add([]);


        }


    }
    private static List<Character> strToList(String str1) {
        List<Character> list;

        if (str1 == null) {
            return list; }
        String str = str1.toUpperCase();
        list = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i).);
        }
        return list;
    }

}


