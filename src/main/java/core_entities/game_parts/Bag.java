package core_entities.game_parts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Bag implements Serializable {
    public ArrayList<Tile> supply;

    /**
     * Creates the list of tiles that are to be in the bag at the beginning of a game.
     * @return List of tiles to be in the bag at the beginning of a game.
     */
    private ArrayList<Tile> generateInitialSupply() {
        char[] letters = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
                                        'B', 'B',
                                        'C', 'C',
                                        'D', 'D', 'D', 'D',
                                        'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E',
                                        'F', 'F',
                                        'G', 'G', 'G',
                                        'H', 'H',
                                        'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',
                                        'J',
                                        'K',
                                        'L', 'L', 'L', 'L',
                                        'M', 'M',
                                        'N', 'N', 'N', 'N', 'N', 'N',
                                        'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
                                        'P', 'P',
                                        'Q',
                                        'R', 'R', 'R', 'R', 'R', 'R',
                                        'S', 'S', 'S', 'S',
                                        'T', 'T', 'T', 'T', 'T', 'T',
                                        'U', 'U', 'U', 'U',
                                        'V', 'V',
                                        'W', 'W',
                                        'X',
                                        'Y', 'Y',
                                        'Z',
                                        '*', '*'};
        ArrayList<Tile> initialSupply = new ArrayList<>();

        for (char letter : letters) {
            initialSupply.add(new Tile(letter));
        }
        return initialSupply;
    }
    /**
     * Constructor for the Class representing the bag of letter tiles of the scrabble game.
     */
    public Bag() {
        this.supply = generateInitialSupply();
    }

    /**
     * Checks whether the bag is empty or not.
     * @return Whether the bag is empty or not.
     */
    public boolean isEmpty(){
        return this.supply.isEmpty();
    }

    /**
     * Takes out a random letter tile from the bag.
     * @return A random Tile.
     */
    public Tile pop(){
        if (this.supply.size() == 0) {
            return null;
        }
        Tile item = getRandomTile();
        this.supply.remove(item);
        return item;
    }

    /**
     * Find a random tile from the bag.
     * @return A random tile from the bag.
     */
    private Tile getRandomTile() {
        Random random = new Random();
        int index = random.nextInt(supply.size());
        return this.supply.get(index);
    }

    /**
     * Takes out number amount of letter tiles from the bag.
     * @param number The number of tiles to be distributed.
     * @return An ArrayList of number amount of tiles
     */
    public ArrayList<Tile> distribute(int number){
        ArrayList<Tile> lst = new ArrayList<>();
        for (int i = 0; i < number; i++){
            lst.add(this.pop());
        }
        return lst;
    }

    /**
     * Adds a list of letter tiles to the bag.
     * @param tiles An ArrayList of Tiles to be added.
     */
    public void add(ArrayList<Tile> tiles){
        this.supply.addAll(tiles);
    }


    /**
     * Adds a letter tile to the bag.
     * @param t The tile to be added.
     */
    public void add(Tile t){
        this.supply.add(t);
    }

    /**
     * Adds a letter tile to the bag.
     * @param c The letter of the tile to be added.
     */
    public void add(char c){
        char letter = Character.toUpperCase(c);
        this.supply.add(new Tile(letter));
    }
}
