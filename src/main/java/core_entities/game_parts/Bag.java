package core_entities.game_parts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Bag implements Serializable {
    /**
     * Class representing the bag of letter tiles of the scrabble game.
     */
    private static final ArrayList<Tile> initialSupply = generateInitialSupply();
    public ArrayList<Tile> supply;

    /**
     * Creates the list of tiles that are to be in the bag at the beginning of a game.
     * @return List of tiles to be in the bag at the beginning of a game.
     */
    private static ArrayList<Tile> generateInitialSupply() {
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
            if (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O'
                    || letter == 'U' || letter == 'L' || letter == 'N' || letter == 'S'
                    || letter == 'T'  || letter == 'R'){
                initialSupply.add(new Tile(letter, 1));
            }
            else if (letter == 'D' || letter == 'G'){
                initialSupply.add(new Tile(letter, 2));
            }
            else if (letter == 'B' || letter == 'C' || letter == 'M' || letter == 'P'){
                initialSupply.add(new Tile(letter, 3));
            }
            else if (letter == 'F' || letter == 'H' || letter == 'V' || letter == 'W'
                    || letter == 'Y'){
                initialSupply.add(new Tile(letter, 4));
            }
            else if (letter == 'K'){
                initialSupply.add(new Tile(letter, 5));
            }
            else if (letter == 'J' || letter == 'X'){
                initialSupply.add(new Tile(letter, 8));
            }
            else {
                initialSupply.add(new Tile(letter, 10));
            }
        }
        return initialSupply;
    }

    public Bag() {
        this.supply = initialSupply;
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
        Tile item = this.supply.get(index);
        return item;
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
}
