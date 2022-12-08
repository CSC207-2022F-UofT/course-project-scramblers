package take_turn_use_case;

import java.io.FileNotFoundException;

import io.View;
import io.ui.logic.PresenterViewModelInterface;
import io.ui.logic.ViewModel;
import place_word_refill_user_story.PlaceWordRefillInteractor;
import place_word_refill_user_story.PlaceWordRefillRequestModel;
import place_word_refill_user_story.PlaceWordRefillResponseModel;
import take_turn.*;
import core_entities.game_parts.*;
import default_reference_values.DefaultBoardDataAccessObject;
import io.ui.logic.Presenter;
import launch_new_game_use_case.LaunchGameDataAccessObject;
import launch_new_game_use_case.LaunchGameRequestModel;
import launch_new_game_use_case.LaunchGameResponseModel;
import launch_new_game_use_case.LaunchNewGameInteractor;
import CoreEntities.IO.DictionaryDataReaderGateway;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import launch_new_game_use_case.*;
import org.junit.jupiter.api.Test;
import place_word_refill_user_story.PlaceWordInputBoundary;
import use_cases.exchange_rack_letters.ExchangeLettersInputBoundary;
import use_cases.save_game_use_case.SaveGameInputBoundary;

public class TakeTurnTest {

    private  TakeTurnOutputBoundary presenter;
    private  PlaceWordInputBoundary placeword;
    private SaveGameInputBoundary saveGame;
    private ExchangeLettersInputBoundary changeletter;


    @Test
    // test place word
    void taketurn1(){
        Presenter p = new Presenter(null) {

            @Override
            public void updateViewModel(LaunchGameResponseModel responseModel) {assert(true);}

            @Override
            public void prepareFailViewAfterExchangingLetters(String message) {
                assert(false);
            }

            @Override
            public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {assert true;}

        };
        try{
            // create game state
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway();
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject();
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human Player", "Computer Player", "Billy", "Joe");
            LaunchNewGameInteractor launchNewGameInteractor = new LaunchNewGameInteractor(p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            launchNewGameInteractor.createGameState(newModel);

            placeword = new PlaceWordRefillInteractor(p);

            // test take turn

            Coordinate cor = new Coordinate(0, 0);
            TakeTrunInputData data = new TakeTrunInputData("E", cor, cor);
            TakeTurnInteractor interactor = new TakeTurnInteractor(p, placeword, changeletter, saveGame);
            interactor.taketurn(data);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    // test exchange tiles
    void taketurn2(){
        Presenter p = new Presenter(null) {

            @Override
            public void updateViewModel(LaunchGameResponseModel responseModel) {assert(true);}

            @Override
            public void prepareFailViewAfterExchangingLetters(String message) {
                assert(false);
            }
            @Override
            public void updateViewModel(PlaceWordRefillResponseModel placeWordRefillResponseModel) {assert true;}

        };
        try{
            // create game state
            CreateDictionaryDataAccessObject dictionaryDataAccessObject = new DictionaryDataReaderGateway();
            BoardFactory factory = new DefaultBoardFactory();
            LaunchGameDataAccessObject boardDataAccessObject = new DefaultBoardDataAccessObject();
            LaunchGameRequestModel newModel = new LaunchGameRequestModel("Human Player", "Computer Player", "Billy", "Joe");
            LaunchNewGameInteractor launchNewGameInteractor = new LaunchNewGameInteractor(p, boardDataAccessObject, dictionaryDataAccessObject, factory);
            launchNewGameInteractor.createGameState(newModel);

            placeword = new PlaceWordRefillInteractor(p);
            // test take turn

            Coordinate cor = new Coordinate(-1, -1);
            TakeTrunInputData data = new TakeTrunInputData("E", cor, cor);
            TakeTurnInteractor interactor = new TakeTurnInteractor(p, placeword, changeletter, saveGame);
            interactor.taketurn(data);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
