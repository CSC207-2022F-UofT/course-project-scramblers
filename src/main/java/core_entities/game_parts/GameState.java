package core_entities.game_parts;

import io.dictionary.DictionaryDataReaderGateway;
import core_entities.player.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameState {
    private static Player p1;
    private static Player p2;
    private static Board board;
    private static int currentPlayer = 0;
    private static Dictionary dict;

    private static  int win;

    private static Bag bag;
    public static Player getP1() {
        return GameState.p1;
    }
    public static void setP1(Player p1) {
        GameState.p1 = p1;
    }
    public static Player getP2() {
        return GameState.p2;
    }
    public static void setP2(Player p2) {
        GameState.p2 = p2;
    }
    public static Board getBoard() {
        return GameState.board;
    }
    public static void setBoard(Board b) {
        GameState.board = b;
    }
    public static void setDictionary(Dictionary d) {
        GameState.dict = d;
    }
    public static void setDictionary(ArrayList<String> dictStrings) throws FileNotFoundException {
        GameState.dict = new Dictionary(dictStrings);
    }
    public static void setWin(int win){
        GameState.win = win;
    }

    public static void setBag(Bag bag){
        GameState.bag = bag;
    }
    public static Dictionary getDictionary() {
        return GameState.dict;
    }
    public static void changeTurn() {
        GameState.currentPlayer = (GameState.currentPlayer + 1) % 2;
    }
    public static void setCurrentPlayer(int i) {
        GameState.currentPlayer = i;
    }
    public static void setCurrentPlayer(Player p) {
        if (GameState.p1.equals(p)) {
            GameState.currentPlayer = 0;
        }
        else if (GameState.p2.equals(p)) {
            GameState.currentPlayer = 1;
        }
    }
    public static Player getCurrentPlayer() {
        if (GameState.currentPlayer == 0) {
            return GameState.p1;
        }
        return GameState.p2;
    }
    public static int getWin(){
        return GameState.win;
    }

    public static Bag getBag(){
        return GameState.bag;
    }
    /**
     *
     * @return A Representation of GameState that can be serialized and accessed for use after saving
     */
    public static SerializableGameState generateSerializableGameState() {
        return new SerializableGameState(GameState.p1, GameState.p2, GameState.board, GameState.currentPlayer, GameState.getDictionary());
    }
}
