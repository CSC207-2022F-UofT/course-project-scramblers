package save_and_restart_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import CoreEntities.IO.Presenter;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import core_entities.game_parts.GameState;
import default_reference_values.DefaultBoardDataAccessObject;
import launch_new_game_use_case.CreateDictionaryDataAccessObject;
import launch_new_game_use_case.LaunchGameDataAccessObject;
import launch_new_game_use_case.LaunchGameRequestModel;
import launch_new_game_use_case.LaunchNewGameInteractor;
import org.junit.jupiter.api.Test;
import storage.StorageManager;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameInteractor;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInteractor;

import java.io.FileNotFoundException;
import java.util.Objects;

public class ReloadGameInteractorTest {

    @Test
    void reloadGame() {


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

            //Saving Game
            SaveGameDsGateway saveGameGateway = new StorageManager();
            SaveGameInteractor saveGameInteractor = new SaveGameInteractor(saveGameGateway);
            saveGameInteractor.save();

            //Testing reload
            ReloadGameDsGateway reloadGameGateway = new StorageManager();
            ReloadGameInteractor interactor = new ReloadGameInteractor(reloadGameGateway);
            assert(interactor.reloadGame());
            assert (Objects.equals(GameState.getP1().getName(), "Billy"));
            assert (Objects.equals(GameState.getP2().getName(), "Joe"));


        } catch(FileNotFoundException e) {
            p.prepareFailView("Saving Game Failed");
        }

    }

}
