//package core_entities.game_parts;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//
///**
// * This class creates a new refined searchable object from the Dictionary class that returns lists of strings
// * for set searches or returns null if no such list can be created.
// *
// */
//
//public class DictionarySearch {
//
//    public ArrayList<String> searchList;
//    public boolean empty;
//
//    public DictionarySearch(String search) throws FileNotFoundException {
//        Dictionary temp_dictionary = new Dictionary();
//        this.searchList = temp_dictionary.getCharacterSetDictionary(search);
//        empty= this.searchList.isEmpty();
//    }
//
//    /**
//     * This method first searches for a specific length of word using an int from paramater length,
//     * it then finds words in that list where there is a specific char value
//     * at the specified index point. It then returns an Arraylist of these words, or null is none.
//     * Precondition: The index value must not be greater than the length -1 of requested word length,
//     * and it must not be a negative value.
//     * @param length int specifying length of chars for words.
//     * @param index specifies the index position for character search.
//     * @param letter specifies the char value to search at index position.
//     * @return an Arraylist of words of a specifc length and with a char value at a specific index.
//     */
//
//    public ArrayList<String> getLengthIndexChar(int length, int index, char letter){
//        if (this.empty){
//            return null;
//        }
//        ArrayList<String> searched; //
//        ArrayList<String> charSearch = new ArrayList<>();
//        searched = findLength(length); // this finds a specific length of word.
//        for(String str: searched){
//            if(str.charAt(index)==letter) {
//                charSearch.add(str);
//            }
//        }
//        return charSearch;
//
//            }//finished fixing the brackets - Joseph S
//
//
//    /**
//     * This method takes in an int len,
//     * and returns an Arraylist of stings that are that length in
//     * chars. If there is no list of strings found it returns null.
//     * @param len is an int determine length.
//     * @return an Arraylist<String></String> or null.
//     */
//    public ArrayList<String> findLength(int len){
//            ArrayList<String> hold =new ArrayList<>();
//        for(String str :this.searchList) {
//            if (str.length() == len) {
//                hold.add(str);
//            }
//        }
//            return hold;
//        }
//
//}
//
