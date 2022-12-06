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
            public void launchTheGame(){
                result = true;
            }

            @Override
            public void reloadGame(){
                result = true;
            }

            @Override
            public void placeWordExecute(String inputWord, String x_coordinate, String y_coordinate){
                result = true;
            }
        };
    }

    @Test
    public void launchGameMethod(){
        controller_reference.launchTheGame();
        assert result;
    }

    @Test
    public void reloadGame(){
        controller_reference.reloadGame();
        assert result;
    }

    @Test
    public void placeWordExecute(){
        controller_reference.placeWordExecute("abc", "1", "0");
        assert result;
    }

}