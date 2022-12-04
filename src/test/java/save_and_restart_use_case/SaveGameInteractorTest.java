package save_and_restart_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import io.ui.logic.Presenter;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import launch_new_game_use_case.*;
import org.junit.jupiter.api.Test;
import storage.StorageManager;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInteractor;
import use_cases.save_game_use_case.SaveGameOutputBoundary;

import java.io.FileNotFoundException;

public class SaveGameInteractorTest {

    /**
     * Tested whether the saving feature can be run without any internal errors
     */
    @Test
    void saveGame() {


        Presenter p = new Presenter(null) {

            @Override
            public void updateViewModel(LaunchGameResponseModel responseModel) {assert(true);}

            @Override
            public void prepareFailView(String message) {
                assert(false);
            }

        };

        try {
            //Creating Game State
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway();
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject();
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human Player", "Computer Player", "Billy", "Joe");
            LaunchNewGameInteractor launchNewGameInteractor = new LaunchNewGameInteractor(p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            launchNewGameInteractor.createGameState(newModel);

            //Testing Save Game
            Presenter saveGamePresenter = new Presenter(null) {

                @Override
                public void updateViewModel(String save_message) {
                    assert(save_message.equals("Game saved successfully"));
                }
                @Override
                public void prepareFailView(String message) {
                    assert(false);
                }
            };

            SaveGameDsGateway gateway = new StorageManager();
            SaveGameInteractor interactor = new SaveGameInteractor(gateway, (SaveGameOutputBoundary) saveGamePresenter);
            assert(interactor.save());

        } catch(FileNotFoundException e) {
            p.prepareFailView("Saving Game Failed");
        }

    }
}
