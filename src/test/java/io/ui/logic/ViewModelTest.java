package io.ui.logic;


import core_entities.player.HumanPlayer;
import core_entities.player.Player;
import core_entities.game_parts.Bag;
import core_entities.game_parts.GameState;
import core_entities.game_parts.LetterRack;
import org.junit.jupiter.api.*;

import java.util.Random;

public class ViewModelTest {

    char[] p1LetterRack;
    char[] p2LetterRack;
    Player p1;
    Player p2;
    ViewModel vm;
    String[][]  boardArray;
    String testText;
    boolean result;


    @BeforeEach
    public void setup(){
        Bag bag = new Bag();
        p1 = new HumanPlayer("bob", new LetterRack(bag, 7), 0);
        p2 = new HumanPlayer("bib", new LetterRack(bag, 7), 0);
        p1LetterRack = p1.getRack().toCharArray();
        p2LetterRack = p2.getRack().toCharArray();
        GameState.setP1(p1);
        GameState.setP2(p2);
        boardArray = new String[][]{{"a", "b"}, {"c", "d"}};
        result = false;
        testText = "";

        vm = new ViewModel(boardArray, null){
            @Override
            public void setMessageText(String messageText){
                testText = messageText;
            }

            @Override
            public void setBoard(String[][] newBoard){
                boardArray = newBoard;
            }

            @Override
            public void updateDisplayLetterRack(char[] inputLetterRack) {

            }
        };
        testText = "";
    }

    /**
     * Updating the letter rack after a change
     */
//    @Test
//    public void updateLetterRackTest(){
//        changeRack(p1.getRack());
//        changeRack(p2.getRack());
//
//        assert (Arrays.equals(p1LetterRack, p1.getRack().toCharArray()));
//        assert (Arrays.equals(p2LetterRack, p2.getRack().toCharArray()));
//
//        vm.updateLetterRacks();
//
//        assert (Arrays.equals(p1LetterRack, p1.getRack().toCharArray()));
//        assert (Arrays.equals(p2LetterRack, p2.getRack().toCharArray()));
//    }

    /**
     * Changes the rack through aliasing
     * @param rack the reference to the rack that is to be changed.
     */
    void changeRack(LetterRack rack){
        Random r = new Random();
        char character = rack.toCharArray()[r.nextInt(rack.getLETTERS().length)];
        rack.removeLetters("" + character);
        rack.refill();
    }
}
