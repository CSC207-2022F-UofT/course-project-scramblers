package save_and_restart_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import CoreEntities.IO.Presenter;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import launch_new_game_use_case.*;
import org.junit.jupiter.api.Test;
import storage.StorageManager;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInteractor;

import java.io.FileNotFoundException;

public class SaveGameInteractorTest {

    /**
     * Tested whether the saving feature can be run without any internal errors
     */
    @Test
    void saveGame() {


        Presenter p = new Presenter() {

            @Override
            public void prepareFailView(String message) {
                assert(false);
            }

        };

        try {
            //Creating Game State
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway("src/main/java/default_reference_values/testDictionary.txt");
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject("src/main/java/default_reference_values/board-data.csv");
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human Player", "Computer Player", "Billy", "Joe");
            LaunchNewGameInteractor launchNewGameInteractor = new LaunchNewGameInteractor(newModel, p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            launchNewGameInteractor.createGameState();

            //Testing Save Game
            SaveGameDsGateway gateway = new StorageManager();
            SaveGameInteractor interactor = new SaveGameInteractor(gateway);
            assert(interactor.save());

        } catch(FileNotFoundException e) {
            p.prepareFailView("Saving Game Failed");
        }

    }
}
