package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;

/**
 * This is an abstract class of node for a LINKED LIST data type.That will store each turn
 * of the game as a word placed on the board. This data will be created differently depending on
 * whether it is Human or Computer, so this ABSTRACT CLASS creates the required properties that each must meet.
 * ----ATTRIBUTES----
 * .data Attribute holds all the information regarding word placement, the available spaces
 * (to speed searching for placements and words).
 * .lastWord holds the last wordNode object in the linkedList design.
 */

abstract class WordNode {

    WordNode nextWord;
    ArrayList<Object> data; // This is temporary until the most efficient method is discovered.
    public WordNode() {
        this.nextWord = null;
        this.data = null;
    }

    /**
     * There are two constructors, one takes in required paramaters,
     * such that it is a continuation of the list.
     * @param lastWord
     * @param data
     */
    public WordNode(WordNode lastWord, ArrayList<Object> data) {
        this.data = data;
        this.nextWord = lastWord;
    }

    /**
     * This setter allows modification when a new node is joined and the data for spaces needs to change.
     * @param data
     */
    public void setData(ArrayList<Object> data) {
        this.data = data;
    }

    /**
     * This getter returns the data from the node.
     * @return
     */
    public ArrayList<Object> getData() {
        return data;
    }

    /**
     * This returns a boolean value of false if and only if the data is null.
     * This is required for iterating through LinkedList, but utilizes a data check
     * rather than a node check.
     * @return
     */
    public boolean anyData() {
        return data.isEmpty();
    }




}
