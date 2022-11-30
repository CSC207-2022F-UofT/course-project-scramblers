package io.ui.logic;


import CoreEntities.Player.HumanPlayer;
import CoreEntities.Player.Player;
import core_entities.game_parts.Bag;
import core_entities.game_parts.LetterRack;
import org.junit.jupiter.api.*;

import java.util.Objects;

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
        boardArray = new String[][]{{"a", "b"}, {"c", "d"}};
        result = false;
        testText = "";

        vm = new ViewModel(boardArray, p1, p2){
            @Override
            public void setMessageText(String messageText){
                testText = messageText;
            }

            @Override
            public void setBoard(String[][] newBoard){
                boardArray = newBoard;
            }

            @Override
            public void updateLetterRacks() {
                p1LetterRack = p1.getRack().toCharArray();
                p2LetterRack = p2.getRack().toCharArray();
            }
        };
        testText = "";
    }
}
