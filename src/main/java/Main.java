import CoreEntities.IO.*;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import launch_new_game_use_case.LaunchGameDataAccessObject;
import launch_new_game_use_case.LaunchNewGameInteractor;

import java.io.FileNotFoundException;


public class Main {
    public static void main (String [] args) {
        // Instantiation of the View, ViewModel and Presenter Objects

        //View view = new View();
        //ViewModel viewModel = new ViewModel();
        //Presenter p = new Presenter(viewModel);

        // Delete the line below once the implemented changes have been made to Presenter
        // This line is just so that Main will compile without error
        Presenter p = new Presenter();

        // LaunchNewGameInteractor Instantiation
        BoardFactory boardFactory = new DefaultBoardFactory();
        DictionaryDataReaderGateway dictionaryGateway;
        try {
            dictionaryGateway = new DictionaryDataReaderGateway("src/main/java/default_reference_values/scrabble_dictionary.txt");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Default dictionary file could not be read");
        }
        LaunchGameDataAccessObject boardAccessObject = new DefaultBoardDataAccessObject();
        LaunchNewGameInteractor newGameInteractor = new LaunchNewGameInteractor(p, boardAccessObject, dictionaryGateway, boardFactory);
    }
}
