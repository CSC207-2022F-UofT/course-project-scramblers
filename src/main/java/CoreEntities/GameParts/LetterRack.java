package CoreEntities.GameParts;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class LetterRack implements Serializable {

    private final Bag BAG_REFERENCE;
    private final Tile[] LETTERS;
    final int RACK_LEN = 7;

    //Default Constructor
    public LetterRack(Bag inputBag) {
        this.BAG_REFERENCE = inputBag;
        this.LETTERS = new Tile[RACK_LEN];
        for (int index = 0; index < RACK_LEN; index++){
            this.LETTERS[index] = this.BAG_REFERENCE.pop();
        }
    }

    /**
     * refills the rack back to full.
     */
    public void refill(){
        for(int index = 0; index < RACK_LEN; index++){
            if(this.LETTERS[index] == null){
                this.LETTERS[index] = this.BAG_REFERENCE.pop();
            }
        }
    }

    /**
     *  Removes letters based on a given string
     * @param inputWord has all letters in the letter rack and len(inputWord) <= RACK_LEN
     */
    public void removeLetters(@NotNull String inputWord){
        for(char characterInWord: inputWord.toCharArray()){
            this.LETTERS[findTile(characterInWord)] = null;
        }
    }

    /**
     * finds the index of a tile based on the given letter
     * @param inputChar the desired character tile to be found in the rack
     * @return index of a tile in letters Array
     */
    private int findTile(char inputChar){
        int outputInt = 0;
        for(Tile tile: this.LETTERS){
            if(tile.getLetter() == inputChar){
                return outputInt;
            }
            else{
                outputInt++;
            }
        }
        return -1; //if error occurs
    }

    /**
     * Determines if the rack is full.
     * @return true if the rack is not full, false otherwise.
     */
    public boolean rackNotFull(){
        for(Tile tile: LETTERS){
            if(tile == null){
                return true;
            }
        }
        return false;
    }

    public Tile[] getLETTERS() {
        return LETTERS;
    }
}
