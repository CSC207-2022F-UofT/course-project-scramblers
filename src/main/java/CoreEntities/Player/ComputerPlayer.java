package CoreEntities.Player;

import core_entities.game_parts.LetterRack;
import CoreEntities.GameParts.Tile;

public class ComputerPlayer extends Player{
    public ComputerPlayer(String name, LetterRack rack, int score) {
        super(name, rack, score);
    }
    /**
     * generate a valid word that can be placed on the board
     * use the makeMove method to place the word
     */
    void generateMove(){

        String result = new String();
        char[] my_char = new char[];

        int i = 0;
        for (Tile letters: rack){
            my_char[i] = letters.getLetter();
            i ++;
        }


        if (result.equals("")){

        }
        else {
            if (makeMove(result)){
                rack.remove(result);
                rack.refill();
            }
            else {}

        }
    }

    @Override
    boolean makeMove(String word, int start_x, int end_x, int start_y, int end_y){return false;}

    @Override
    void replaceLetters(char[] toReplaceValues, char[] newValues) {

    }
}
