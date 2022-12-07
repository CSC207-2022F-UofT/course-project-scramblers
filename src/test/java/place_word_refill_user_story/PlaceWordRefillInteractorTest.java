package place_word_refill_user_story;

import CoreEntities.IO.DictionaryDataReaderGateway;
import core_entities.game_parts.*;
import default_reference_values.DefaultBoardDataAccessObject;
import io.ui.logic.Presenter;
import launch_new_game_use_case.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

class PlaceWordRefillInteractorTest {
    private Presenter presenter;
    @BeforeEach
    void init() throws FileNotFoundException {
        LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject();
        BoardFactory boardFactory = new DefaultBoardFactory();
        CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway();
        LaunchGameRequestModel gameRequestModel = new LaunchGameRequestModel("Human Player",
                "Human Player", "Human 1", "Human 2");
        presenter = new Presenter() {
            @Override
            public void updateViewModel(PlaceWordRefillResponseModel responseModel){
                assert responseModel.isSuccess();
            }
            @Override
            public void updateViewModel(LaunchGameResponseModel responseModel) {
                assert(true);
            }

            @Override
            public void prepareFailView(String message) {
                assert(false);
            }
        };
        LaunchNewGameInteractor gameInteractor = new LaunchNewGameInteractor(presenter,
                boardDataAccessObject, dictionaryDataAccessObject, boardFactory);
        gameInteractor.createGameState(gameRequestModel);
    }

    /**
     * Tests if a word can be placed on an empty board using valid tiles to make a word from the dictionary.
     */
    @Test
    void placeWordEmptyBoard() {
        // ArrayList<String> possibleWords = GameState.getDictionary().getCharacterSetDictionary(
                // Arrays.toString(GameState.getCurrentPlayer().getRack().getLETTERS()));
        char letterOne = GameState.getCurrentPlayer().getRack().getLETTERS()[0].getLetter();
        char letterTwo = GameState.getCurrentPlayer().getRack().getLETTERS()[1].getLetter();
        String newString = Character.toString(letterOne).concat(Character.toString(letterTwo));
        PlaceWordRefillRequestModel requestModel = new PlaceWordRefillRequestModel(newString,
                new Coordinate(0, 0), new Coordinate(0, 1));
        PlaceWordRefillInteractor interactor = new PlaceWordRefillInteractor(presenter);
        interactor.placeWordRefill(requestModel);
    }

    /**
     * Tests if a word can be placed on a board using valid tiles and an existing tile on the board
     * to make a word from the dictionary.
     */
    @Test
    void placeWordWithExistingTile() {
//        ArrayList<String> possibleWords = Dictionary.getCharacterSetDictionary(
//                Arrays.toString(GameState.getCurrentPlayer().getRack().getLETTERS()));
        char letterOne = GameState.getCurrentPlayer().getRack().getLETTERS()[0].getLetter();
        char letterTwo = GameState.getCurrentPlayer().getRack().getLETTERS()[1].getLetter();
        String newString = Character.toString(letterOne).concat(Character.toString(letterTwo));
        Tile existingTile = new Tile(letterOne, 10);
        Tile[] existingTiles = {existingTile};
        GameState.getBoard().placeTiles(existingTiles, new Coordinate(0,0), new Coordinate(0,0));
        PlaceWordRefillRequestModel requestModel = new PlaceWordRefillRequestModel(newString,
                new Coordinate(0, 0), new Coordinate(0, 1));
        PlaceWordRefillInteractor interactor = new PlaceWordRefillInteractor(presenter);
        interactor.placeWordRefill(requestModel);
    }

    /**
     * Tests if a word can be placed on the board in an invalid space.
     */
    @Test
    void placeWordInvalidPlacement() {
        presenter = new Presenter() {
            @Override
            public void updateViewModel(PlaceWordRefillResponseModel responseModel){
                assert (false);
            }

            @Override
            public void prepareFailView(String message) {
                assert true;
            }
        };
//        ArrayList<String> possibleWords = Dictionary.getCharacterSetDictionary(
//                Arrays.toString(GameState.getCurrentPlayer().getRack().getLETTERS()));
        char letterOne = GameState.getCurrentPlayer().getRack().getLETTERS()[0].getLetter();
        char letterTwo = GameState.getCurrentPlayer().getRack().getLETTERS()[1].getLetter();
        String newString = Character.toString(letterOne).concat(Character.toString(letterTwo));
        Tile existingTile = new Tile(letterTwo, 10);
        Tile[] existingTiles = {existingTile};
        GameState.getBoard().placeTiles(existingTiles, new Coordinate(0,0), new Coordinate(0,0));
        PlaceWordRefillRequestModel requestModel = new PlaceWordRefillRequestModel(newString,
                new Coordinate(0, 0), new Coordinate(0, 1));
        PlaceWordRefillInteractor interactor = new PlaceWordRefillInteractor(presenter);
        interactor.placeWordRefill(requestModel);
    }
}
