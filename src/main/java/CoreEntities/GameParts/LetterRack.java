package CoreEntities.GameParts;

import java.io.Serializable;
import java.util.Arrays;

public class LetterRack implements Serializable {

    private Bag bagReference;
    private Tile[] letters;
    final int RACK_LEN = 7;

    //Default Constructor
    public LetterRack(Bag inputBag) {
        this.bagReference = inputBag;
        this.letters = new Tile[RACK_LEN];
        for (int index = 0; index < RACK_LEN; index++){
            this.letters[index] = this.bagReference.pop();
        }
    }

    public boolean refill(){

    }

    /**
     *  Removes letters based on a given string
     * @param inputWord have all letters in the letter rack
     * @return nothing but object is modified with the letters specified removes
     */
    public boolean removeLetters(String inputWord){
        for(char characterInWord: inputWord){
            this.letters[]
        }
    }

    private int findTile(char inputChar){
        int output = 0;
        for(Tile tile: letters){
            if(tile)
        }
    }

    public boolean rackNotFull(){
        for(Tile tile: letters){
            if(tile == null){
                return true;
            }
        }
        return false;
    }
}
