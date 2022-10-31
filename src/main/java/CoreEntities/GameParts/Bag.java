package CoreEntities.GameParts;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
    static final ArrayList<Tile> initialSupply = generateInitialSupply();
    public ArrayList<Tile> supply;

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

    public boolean isEmpty(){
        return this.supply.isEmpty();
    }

    public Tile pop(){
        Random random = new Random();
        int index = random.nextInt(supply.size());
        Tile item = this.supply.get(index);
        this.supply.remove(item);
        return item;
    }

    public ArrayList<Tile> distribute(int number){
        ArrayList<Tile> lst = new ArrayList<>();
        for (int i = 0; i < number; i++){
            lst.add(pop());
        }
        return lst;
    }

    public void add(ArrayList<Tile> tiles){
        this.supply.addAll(tiles);
    }

    public void add(Tile t){
        this.supply.add(t);
    }
}
