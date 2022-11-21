package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;

/**
 * This Class is a Node for a LinkedList of a word created by Computer.
 * It's ATTRIBUTE  lastWord holds the previous placed Wordnode link in the list.
 * Its date attribute holds available space for future words to be placed and the chars needed to
 * search for future words
 *
 */
public class ComputerWord extends WordNode{

    WordNode lastWord;
    ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> data;
    public ComputerWord() {
        this.lastWord = null;
        this.data= null;
    }

    public ComputerWord(WordNode node, ArrayList<ArrayList<ArrayList<ArrayList<Integer>>>> data) {

    }

    /**
     * @param data This data is constructed  [0,8,[7, [-6,65,6]],[8,[-6,66,6]],
     */
    @Override
    public void setData(ArrayList<Object> data) {
        super.setData(data);
    }

    /**
     * @return
     */
    @Override
    public ArrayList<Object> getData() {
        return super.getData();
    }

    /**
     * @return
     */
    @Override
    public boolean anyData() {
        return super.anyData();
    }
}
