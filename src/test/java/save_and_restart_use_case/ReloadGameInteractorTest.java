package save_and_restart_use_case;

import CoreEntities.IO.DictionaryDataReaderGateway;
import io.ui.logic.Presenter;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import core_entities.game_parts.GameState;
import default_reference_values.DefaultBoardDataAccessObject;
import launch_new_game_use_case.*;
import org.junit.jupiter.api.Test;
import storage.StorageManager;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameInteractor;
import use_cases.reload_game_use_case.ReloadGameOutputBoundary;
import use_cases.reload_game_use_case.ReloadGameResponseModel;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInteractor;
import use_cases.save_game_use_case.SaveGameOutputBoundary;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class ReloadGameInteractorTest {

    /**
     * Testing whether the information of a previous version of GameState can be re-added to the current version
     * of GameState
     */
    @Test
    void reloadGame() {


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

            //Saving Game
            SaveGameDsGateway saveGameGateway = new StorageManager();
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
            SaveGameInteractor saveGameInteractor = new SaveGameInteractor(saveGameGateway, (SaveGameOutputBoundary) saveGamePresenter);
            saveGameInteractor.save();

            //Testing reload
            Presenter reloadGamePresenter = new Presenter(null) {

                @Override
                public void updateViewModel(ReloadGameResponseModel responseModel) {
                    assert(Arrays.deepEquals(responseModel.getMultiplierGrid(), GameState.getBoard().getMultiplierGrid()));
                    assert(Arrays.deepEquals(responseModel.getCharacterGrid(), GameState.getBoard().getLetterGrid()));
                    assert(Arrays.equals(responseModel.getLetterRack(), GameState.getCurrentPlayer().getRack().toCharArray()));
                }
                @Override
                public void prepareFailView(String message) {
                    assert(false);
                }
            };
            ReloadGameDsGateway reloadGameGateway = new StorageManager();
            ReloadGameInteractor interactor = new ReloadGameInteractor(reloadGameGateway, (ReloadGameOutputBoundary) reloadGamePresenter);
            assert(interactor.reloadGame());
            assert (Objects.equals(GameState.getP1().getName(), "Billy"));
            assert (Objects.equals(GameState.getP2().getName(), "Joe"));


        } catch(FileNotFoundException e) {
            p.prepareFailView("Saving Game Failed");
        }

    }

}
