package CoreEntities.Player;

import core_entities.game_parts.*;

public class ComputerPlayer extends Player{
    public ComputerPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }

    /**
     * Place the word that is generated
     * @param word the word that is generated
     * @param start_x the starting x-axis of the word
     * @param end_x the ending x-axis of the word
     * @param start_y the starting y-axis of the word
     * @param end_y the ending y-exist of the word
     * @return return true if the word is placed
     */
    @Override
    boolean makeMove(String word, int start_x, int end_x, int start_y, int end_y) {
        Coordinate c1 = new Coordinate(start_x, start_y);
        Coordinate c2 = new Coordinate(end_x, end_y);
        Tile [] tilelist_1 = new Tile[7];
        int flag = 0;

        for (int i = 0; i < word.length(); i++){
            int pos = rack.findTile(word.charAt(i));
            if (pos != -1){
                tilelist_1[i] = rack.getLETTERS()[pos];
                flag ++;
            }
        }

        rack.removeLetters(word);
        rack.refill();

        Tile[] tileList = new[flag];
        System.arraycopy(tilelist_1, 0, tileList, 0, flag);

        // Error of Non-static method cannot be referenced from a static context
        Board.placeTiles(tileList, c1, c2);


        return false;
    }

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }
}
