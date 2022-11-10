package CoreEntities.GameParts;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class LetterRack implements Serializable {

    private final Bag BAG_REFERENCE;
    private final Tile[] LETTERS;
    int rackLen; //Not final since we're opening it to expandability for custom games

    //Default Constructor that will be used in the program
    public LetterRack(Bag inputBag) {
        this.rackLen = 7;
        this.BAG_REFERENCE = inputBag;
        this.LETTERS = new Tile[rackLen];
        for (int index = 0; index < rackLen; index++){
            this.LETTERS[index] = this.BAG_REFERENCE.pop();
        }
    }

    /**
     * refills the rack back to full.
     */
    public void refill(){
        for(int index = 0; index < rackLen; index++){
            if(this.LETTERS[index] == null){
                this.LETTERS[index] = this.BAG_REFERENCE.pop();
            }
        }
    }

    /**
     *  Removes letters based on a given string
     * @param inputWord is an all alphabetical string and len(inputWord) <= RACK_LEN
     */
    public void removeLetters(@NotNull String inputWord){
        for(char characterInWord: inputWord.toCharArray()){
            int index = findTile(characterInWord);
            if(index != -1 ) {
                this.LETTERS[index] =null;
            }
        }
    }

    /**
     * finds the index of a tile based on the given letter
     * @param inputChar the desired character tile to be found in the rack
     * @return index of a tile in letters Array
     */
    private int findTile(char inputChar){
        int outputTileIndex = 0;
        for(Tile tile: this.LETTERS){
            if(tile.getLetter().charAt(0) == inputChar){
                return outputTileIndex;
            }
            else{
                outputTileIndex++;
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
