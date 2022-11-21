package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;
import java.util.List;

/**
 * -----THIS IS A TEST CLASS TO SEE IF ITS MORE EFFICIENT THAN RAW DATA IN WORDNODE>
 * NOT CURRENTLY FOR IMPLEMENTATION-----
 *
 * ----ATTRIBUTE AND DETAILS TO FOLLOW ON IMPLEMENTATION-------
 *
 *
 * Key concepts to Data storage that I'm testing->
 * (1)The fact that Char values are in fact Unicode numbers.
 * Thus, to store and access can be very fast. Example Char myChar ='Z'; can be converted to unicode
 * simply by int Z = myChar +0; OR, casting (int) myChar in line...
 * (2)Updating and separating available spots for above/left and below/right.
 * this separation is done this way due to the 0,0 axis in the top left,
 * thus above and left will always be negative from the working coordinate and
 * below/right will always be positive.
 *
 * (3) [KEY ISSUE]The jointIndexes value can quickly update available space in the preceding Worddata, by using
 * a formula of the new words joint intersect value (x,y) its Char intercept,
 * and then calculating the same value from the previous word, and subtracting open space
 * values by -> Formula: .previous.previous(joint(below/above ie positive/negative) +.previous(joint(below/above))
 * gives where and how many open spaces disappear (if any) from previous previous open
 * word space.
 *
 *
 */
class WordData {
    ArrayList<int[]> leftUpperAvail;
    ArrayList<int[]> rightLowerAvail;
    int direction;
    int stableDirection;
    ArrayList<Integer> jointIndexes;
    ArrayList<Character> word;
    public WordData(ArrayList<Character> word, int direction,int start,  int stableDirection, int joint) {
        this.direction = direction;
        this.stableDirection = stableDirection;
        this.word = word;
        this.jointIndexes.add(joint);



    }

    private ArrayList<Integer> findopen(int start, int direction){
        int length = this.word.size();
        for(int i=0; i<length; i++){
            if

        }

    }

    //    public WordData(String word,int first, int second, int hOrV) {
//        ArrayList wordValue = null;
//        int stableDirection;
//        int constant;
//        if (hOrV==0){
//            stableDirection = second;
//            constant=first;}
//        else {
//            stableDirection=first;
//            constant=second;
//        }
//        ArrayList<Character> wordChars = (ArrayList<Character>) strToList(word);
//        for(int i = 0; i <= wordChars.size(); i++){
//
//            int myChar = wordChars.get(i) +0;
//            wordValue.add();




        /**
         * This function converts a string to a list of Char values
         */
//    }
    private static List<Character> strToList(String str1) {
        List<Character> list = null;

        if (str1 == null) {
            return list; }
        String str = str1.toUpperCase();
        list = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list;
    }

}


