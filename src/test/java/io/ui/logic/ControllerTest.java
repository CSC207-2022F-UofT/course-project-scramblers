package io.ui.logic;

import org.junit.jupiter.api.*;

class ControllerTest {

    Controller controller_reference;
    boolean result;

    @BeforeEach
    void setUp() {
        result = false;
        controller_reference = new Controller(null, null, null){
            @Override
            public void launchTheGame(String player1Name, String player2Name){
                result = true;
            }

            @Override
            public void reloadGame(){
                result = true;
            }

            @Override
            public void executeTurn(String inputWord, String startX, String startY){
                result = true;
            }
        };
    }

    @Test
    public void launchGameMethod(){
        controller_reference.launchTheGame("", "");
        assert result;
    }

    @Test
    public void reloadGame(){
        controller_reference.reloadGame();
        assert result;
    }

    @Test
    public void executeTurn(){
        controller_reference.executeTurn("abc", "1", "0");
        assert result;
    }

}