package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;

/**
 * This is an abstract class of node for a linked list.
 */

abstract class WordNode {

    WordNode nextWord;
    ArrayList<Object> data;
    public WordNode() {
        this.nextWord = null;
        this.data = null;
    }

    public WordNode(WordNode nextWord, ArrayList<Object> data) {
        this.data = data;
        this.nextWord = nextWord;
    }

    public void setData(ArrayList<Object> data) {
        this.data = data;
    }

    public ArrayList<Object> getData() {
        return data;
    }


    public boolean anyData() {
        return data.isEmpty();
    }




}
