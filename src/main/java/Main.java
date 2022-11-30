import CoreEntities.IO.*;
import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.DefaultBoardFactory;
import default_reference_values.DefaultBoardDataAccessObject;
import io.ui.logic.Presenter;
import launch_new_game_use_case.LaunchGameDataAccessObject;
import launch_new_game_use_case.LaunchGameOutputBoundary;
import launch_new_game_use_case.LaunchNewGameInteractor;

import java.io.FileNotFoundException;


public class Main {
    public static void main (String [] args) {
        // Instantiation of the View, ViewModel and Presenter Objects

        //View view = new View();
        //ViewModel viewModel = new ViewModel();
        //viewModel.addObserver(view)
        //Presenter p = new Presenter(viewModel);

        // Delete the line below once the implemented changes have been made to Presenter
        // This line is just so that Main will compile without error
        Presenter p = new Presenter(null);

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
        LaunchGameOutputBoundary newGameOutputBoundary = p;
        LaunchNewGameInteractor newGameInteractor = new LaunchNewGameInteractor(newGameOutputBoundary, boardAccessObject, dictionaryGateway, boardFactory);

        //Controller Instantiation

        //Change this to Controller once Controller is created
        //ViewController c = new ViewController();

        //Add all the use case interactors to the Controller
        // c.addInteractor(newGameInteractor);

        //Add the controller to the View
        //View.addController(c);

        //Set the view to be visible
        //view.setVisible();
    }
}
