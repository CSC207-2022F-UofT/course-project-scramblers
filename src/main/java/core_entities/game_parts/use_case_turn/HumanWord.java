package core_entities.game_parts.use_case_turn;

import java.util.ArrayList;

public class HumanWord extends WordNode{
    public HumanWord() {
    }

    public HumanWord(WordNode nextWord, ArrayList<Object> data) {
        super(nextWord, data);
    }

    /**
     * @param data
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
