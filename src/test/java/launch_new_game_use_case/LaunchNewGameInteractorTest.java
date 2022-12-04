package launch_new_game_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import io.ui.logic.Presenter;
import default_reference_values.DefaultBoardDataAccessObject;
import org.junit.jupiter.api.Test;
import core_entities.game_parts.*;
import CoreEntities.Player.*;

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
            public void updateViewModel(LaunchGameResponseModel responseModel) {
                String [][] boardData = responseModel.getBoardLayout();
                assert(Arrays.deepEquals(boardData, expectedBoardValues));
                assert(GameState.getP1() instanceof HumanPlayer);
                assert(GameState.getP2() instanceof ComputerPlayer);
            }
            @Override
            public void prepareFailView(String message) {
                assert(false);
            }
        };
        try {
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway();
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject();
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human Player", "Computer Player", "Billy", "Joe");
            LaunchNewGameInteractor interactor = new LaunchNewGameInteractor(p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            interactor.createGameState(newModel);
        }
        catch(FileNotFoundException e) {
            p.prepareFailView("Dictionary Creation Failed");
        }
    }
}