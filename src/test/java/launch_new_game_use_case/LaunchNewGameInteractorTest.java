package launch_new_game_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import CoreEntities.IO.Presenter;
import default_reference_values.DefaultBoardDataAccessObject;
import org.junit.jupiter.api.Test;
import core_entities.game_parts.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

class LaunchNewGameInteractorTest {

    @Test
    void createGameState() {
        String [][] expectedBoardValues = {
                {"W3", "*", "*", "L2", "*", "*", "*", "W3", "*", "*", "*", "L2", "*", "*", "W3"},
                {"*", "W2", "*", "*", "*", "L3", "*", "*", "*", "L3", "*", "*", "*", "W2", "*"},
                {"*", "*", "W2", "*", "*", "*", "L2", "*", "L2", "*", "*", "*", "W2", "*", "*"},
                {"L2", "*", "*", "W2", "*", "*", "*", "L2", "*", "*", "*", "W2", "*", "*", "L2"},
                {"*", "*", "*", "*", "W2", "*", "*", "*", "*", "*", "W2", "*", "*", "*", "*"},
                {"*", "L3", "*", "*", "*", "L3", "*", "*", "*", "L3", "*", "*", "*", "L3", "*"},
                {"*", "*", "L2", "*", "*", "*", "L2", "*", "L2", "*", "*", "*", "L2", "*", "*"},
                {"W3", "*", "*", "L2", "*", "*", "*", "W2", "*", "*", "*", "L2", "*", "*", "W3"},
                {"*", "*", "L2", "*", "*", "*", "L2", "*", "L2", "*", "*", "*", "L2", "*", "*"},
                {"*", "L3", "*", "*", "*", "L3", "*", "*", "*", "L3", "*", "*", "*", "L3", "*"},
                {"*", "*", "*", "*", "W2", "*", "*", "*", "*", "*", "W2", "*", "*", "*", "*"},
                {"L2", "*", "*", "W2", "*", "*", "*", "L2", "*", "*", "*", "W2", "*", "*", "L2"},
                {"*", "*", "W2", "*", "*", "*", "L2", "*", "L2", "*", "*", "*", "W2", "*", "*"},
                {"*", "W2", "*", "*", "*", "L3", "*", "*", "*", "L3", "*", "*", "*", "W2", "*"},
                {"W3", "*", "*", "L2", "*", "*", "*", "W3", "*", "*", "*", "L2", "*", "*", "W3"}
        };
        Presenter p = new Presenter() {
            @Override
            public void updateViewModel(String [][] boardData) {
                assert(Arrays.deepEquals(boardData, expectedBoardValues));
            }
            @Override
            public void prepareFailView(String message) {
                assert(false);
            }
        };
        try {
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway("src/main/java/default_reference_values/testDictionary.txt");
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject("src/main/java/default_reference_values/board-data.csv");
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human", "Computer", "Billy", "Joe");
            LaunchNewGameInteractor interactor = new LaunchNewGameInteractor(newModel, p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            interactor.createGameState();
        }
        catch(FileNotFoundException e) {
            p.prepareFailView("Dictionary Creation Failed");
        }
    }
}