package io.ui.logic;

import launch_new_game_use_case.LaunchGameInputBoundary;
import launch_new_game_use_case.LaunchGameRequestModel;
import place_word_refill_user_story.PlaceWordInputBoundary;
import use_cases.reload_game_use_case.*;

public class Controller {
    //Should reference every input boundary made
    private final LaunchGameInputBoundary LAUNCH_GAME_REF;
    private final ReloadGameInputBoundary RELOAD_GAME_REF;
    private final TakeTrunInputBoundary TAKE_TURN_INPUT_REF;


    //Constructor that's going to be used.
    public Controller(LaunchGameInputBoundary launchGameInput,
               ReloadGameInputBoundary reloadGameInputBoundary,
               PlaceWordInputBoundary placeWordInputBoundary){
        LAUNCH_GAME_REF = launchGameInput;
        RELOAD_GAME_REF = reloadGameInputBoundary;
        PLACE_WORD_INPUT_REF = placeWordInputBoundary;
    }

    public void launchTheGame(){
        LAUNCH_GAME_REF.createGameState(new LaunchGameRequestModel("Human Player",
                "Human Player",
                "Player 1",
                "Player 2"));
    }

    public void reloadGame(){
        RELOAD_GAME_REF.reloadGame();
    }

    public void placeWordExecute(String inputWord, String x_coordinate, String y_coordinate) {

        //PLACE_WORD_INPUT_REF.placeWordRefill();

    }
}
