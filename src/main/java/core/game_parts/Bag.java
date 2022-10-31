package core.game_parts;

import java.util.ArrayList;
import java.util.Random;

public class Bag {
    static final ArrayList<Tile> initialSupply = generateInitialSupply();
    public ArrayList<Tile> supply;

    private static ArrayList<Tile> generateInitialSupply() {
        String[] letters = new String[]{"A", "A", "A", "A", "A", "A", "A", "A", "A",
                                        "B", "B",
                                        "C", "C",
                                        "D", "D", "D", "D",
                                        "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E", "E",
                                        "F", "F",
                                        "G", "G", "G",
                                        "H", "H",
                                        "I", "I", "I", "I", "I", "I", "I", "I", "I",
                                        "J",
                                        "K",
                                        "L", "L", "L", "L",
                                        "M", "M",
                                        "N", "N", "N", "N", "N", "N",
                                        "O", "O", "O", "O", "O", "O", "O", "O",
                                        "P", "P",
                                        "Q",
                                        "R", "R", "R", "R", "R", "R",
                                        "S", "S", "S", "S",
                                        "T", "T", "T", "T", "T", "T",
                                        "U", "U", "U", "U",
                                        "V", "V",
                                        "W", "W",
                                        "Y", "Y",
                                        "Z",
                                        "*", "*"};
        ArrayList<Tile> initialSupply = new ArrayList<>();
        for (String letter : letters) {
            if (letter.equals("A") || letter.equals("E") || letter.equals("I") || letter.equals("O")
                    || letter.equals("U") || letter.equals("L") || letter.equals("N")  || letter.equals("S")
                    || letter.equals("T")  || letter.equals("R")){
                initialSupply.add(new Tile(letter, 1));
            }
            else if (letter.equals("D") || letter.equals("G")){
                initialSupply.add(new Tile(letter, 2));
            }
            else if (letter.equals("B") || letter.equals("C") || letter.equals("M") || letter.equals("P")){
                initialSupply.add(new Tile(letter, 3));
            }
            else if (letter.equals("F") || letter.equals("H") || letter.equals("V") || letter.equals("W")
                    || letter.equals("Y")){
                initialSupply.add(new Tile(letter, 4));
            }
            else if (letter.equals("K")){
                initialSupply.add(new Tile(letter, 5));
            }
            else if (letter.equals("J") || letter.equals("X")){
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
        int length = supply.size();
        Random random = new Random();
        int index = random.nextInt(length);
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

    public void add(Tile t){
        this.supply.add(t);
    }
}
