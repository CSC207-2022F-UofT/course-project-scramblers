package core_entities.game_parts;

import CoreEntities.GameParts.Bag;
import CoreEntities.GameParts.Tile;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class LetterRack implements Serializable {

    private final Bag BAG_REFERENCE;
    private Tile[] letters;
    private int rackLen; //Not final since we're opening it to expandability for custom games

    //Default Constructor that will be used in the program
    public LetterRack(Bag inputBag, int inputRackLen) {
        this.rackLen = inputRackLen;
        this.BAG_REFERENCE = inputBag;
        this.letters = new Tile[this.rackLen];
        refill();
    }

    /**
     * refills the rack back to full.
     */
    public void refill(){
        for(int index = 0; index < this.rackLen; index++){
            if(this.letters[index] == null){
                this.letters[index] = this.BAG_REFERENCE.pop();
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
                this.letters[index] =null;
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
        for(Tile tile: this.letters){
            if(tile.getLetter() == inputChar){
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
        for(Tile tile: this.letters){
            if(tile == null){
                return true;
            }
        }
        return false;
    }

    /**
     * Change the length of the rack after a game is finished
     * and a new rank length has been set.
     * Note: this does not save the previous rack, it resets it entirely.
     * @param newRackLen > 0
     */
    public void changeRackLength(int newRackLen){
        //empty the original rack
        emptyingTheRack();
        this.rackLen = newRackLen;
        this.letters = new Tile[this.rackLen];

        refill();//refill the new rack
    }

    /**
     * Self-explanatory
     */
    private void emptyingTheRack() {
        for(int x = 0; x < this.rackLen; x++){
            if (this.letters[x] != null) {
                this.BAG_REFERENCE.add(this.letters[x]);
                this.letters[x] = null;
            }
        }
    }

    public Tile[] getLetters() {
        return this.letters;
    }
}
