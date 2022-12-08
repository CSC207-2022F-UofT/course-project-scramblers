import io.dictionary.DictionaryDataReaderGateway;
import use_cases.take_turn.TakeTrunInputBoundary;
import use_cases.take_turn.TakeTurnInteractor;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import io.ViewFinal;
import io.ui.logic.*;
import use_cases.launch_new_game_use_case.*;
import use_cases.place_word_refill_user_story.PlaceWordInputBoundary;
import use_cases.place_word_refill_user_story.PlaceWordRefillInteractor;
import storage.StorageManager;
import use_cases.exchange_rack_letters.ExchangeLettersInputBoundary;
import use_cases.exchange_rack_letters.ExchangeLettersInteractor;
import use_cases.reload_game_use_case.ReloadGameDsGateway;
import use_cases.reload_game_use_case.ReloadGameInputBoundary;
import use_cases.reload_game_use_case.ReloadGameInteractor;
import use_cases.save_game_use_case.SaveGameDsGateway;
import use_cases.save_game_use_case.SaveGameInputBoundary;
import use_cases.save_game_use_case.SaveGameInteractor;

import java.io.FileNotFoundException;


public class Main {

    public static void main (String [] args) throws FileNotFoundException {

        ViewFinal view = new ViewFinal();
        ViewModel viewModel = new ViewModel(null, view);
        // Pass in an instance of view to view model for observer

        Presenter p = new Presenter(viewModel);

        // Interactor Instantiations
        BoardFactory boardFactory = new DefaultBoardFactory();

        DictionaryDataReaderGateway dictionaryGateway = new DictionaryDataReaderGateway("src/main/java/default_reference_values/scrabble_dictionary.txt");
//        try {
//            dictionaryGateway = new DictionaryDataReaderGateway();
//        }
//        catch (FileNotFoundException e) {
//            throw new RuntimeException("Default dictionary file could not be read");
//        }

        LaunchGameDataAccessObject boardAccessObject = new DefaultBoardDataAccessObject();
        LaunchNewGameInteractor launchGameInteractor = new LaunchNewGameInteractor(p, boardAccessObject, dictionaryGateway, boardFactory);

        ReloadGameDsGateway reloadGameGateway = new StorageManager();
        ReloadGameInputBoundary reloadGameInteractor = new ReloadGameInteractor(reloadGameGateway, p);

        SaveGameDsGateway saveGameGateway = new StorageManager();
        SaveGameInputBoundary saveGameInteractor = new SaveGameInteractor(saveGameGateway, p);

        PlaceWordInputBoundary placeWordInteractor = new PlaceWordRefillInteractor(p);

        ExchangeLettersInputBoundary exchangeLettersInteractor = new ExchangeLettersInteractor();

        TakeTrunInputBoundary takeTurnInteractor = new TakeTurnInteractor(p, placeWordInteractor, exchangeLettersInteractor, saveGameInteractor);

        Controller c = new Controller(launchGameInteractor, reloadGameInteractor, takeTurnInteractor);
        // Add saveGameInteractor to Controller

        //Add the controller to the View
        view.setController(c);
    }
}
