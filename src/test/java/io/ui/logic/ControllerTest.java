package io.ui.logic;

import org.junit.jupiter.api.*;

class ControllerTest {

    Controller controller_reference;
    boolean result;

    @BeforeEach
    void setUp() {
        result = false;
        controller_reference = new Controller(){
            @Override
            public void launchTheGame(){
                result = true;
            }

            @Override
            public void reloadGame(){
                result = true;
            }

            @Override
            public void placeWordExecute(String inputWord){
                result = isOnlyAlphabetString(inputWord);
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
    public void alphabetCheckerTest(){
        assert controller_reference.isOnlyAlphabetString("abc");
    }

    @Test
    public void alphabetCheckerNoLetters(){
        assert controller_reference.isOnlyAlphabetString("");
    }

    @Test
    public void alphabetCheckerFalseCase(){
        result = !(controller_reference.isOnlyAlphabetString("123"));
        assert result;
    }

    @Test
    public void placeWordExecute(){
        controller_reference.placeWordExecute("abc");
        assert result;
    }

}