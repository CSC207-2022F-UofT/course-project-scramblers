import CoreEntities.IO.DictionaryDataReaderGateway;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import io.View;
import io.ui.logic.*;
import launch_new_game_use_case.*;
import place_word_refill_user_story.PlaceWordInputBoundary;
import place_word_refill_user_story.PlaceWordRefillInteractor;
import storage.StorageManager;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameInputBoundary;
import use_cases.reload_game_use_case.ReloadGameInteractor;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInputBoundary;
import use_cases.save_game_use_case.SaveGameInteractor;

import java.io.FileNotFoundException;


public class Main {
    public static void main (String [] args) {
        View view = new View();
        ViewModel viewModel = new ViewModel(null, null, null);
        viewModel.addObserver(view);
        // Resolve issue with p1 and p2

        Presenter p = new Presenter(viewModel);

        // Interactor Instantiations
        BoardFactory boardFactory = new DefaultBoardFactory();
        DictionaryDataReaderGateway dictionaryGateway;
        try {
            dictionaryGateway = new DictionaryDataReaderGateway("src/main/java/default_reference_values/scrabble_dictionary.txt");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Default dictionary file could not be read");
        }
        LaunchGameDataAccessObject boardAccessObject = new DefaultBoardDataAccessObject();
        LaunchNewGameInteractor launchGameInteractor = new LaunchNewGameInteractor(p, boardAccessObject, dictionaryGateway, boardFactory);

        ReloadGameDsGateway reloadGameGateway = new StorageManager();
        ReloadGameInputBoundary reloadGameInteractor = new ReloadGameInteractor(reloadGameGateway);
        // Add presenter to reloadGameInteractor

        SaveGameDsGateway saveGameGateway = new StorageManager();
        SaveGameInputBoundary saveGameInteractor = new SaveGameInteractor(saveGameGateway);
        // Add presenter to saveGameInteractor

        PlaceWordInputBoundary placeWordInteractor = new PlaceWordRefillInteractor(p);

        Controller c = new Controller(launchGameInteractor, reloadGameInteractor, placeWordInteractor);
        // Add saveGameInteractor to Controller

        //Add the controller to the View
        view.setController(c);

        //Set the view to be visible
        view.setVisible(true);
    }
}
