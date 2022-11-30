package io.ui.logic;

import launch_new_game_use_case.LaunchGameInputBoundary;
import launch_new_game_use_case.LaunchGameRequestModel;
import place_word_refill_user_story.PlaceWordInputBoundary;
import use_cases.reload_game_use_case.*;

import java.util.regex.Pattern;

public class Controller {
    //Should reference every input boundary made
    private final LaunchGameInputBoundary LAUNCH_GAME_REF;
    private final ReloadGameInputBoundary RELOAD_GAME_REF;
    private final PlaceWordInputBoundary PLACE_WORD_INPUT_REF;

    //constructor that's ONLY going to be used for testing.
    Controller(){
        this.LAUNCH_GAME_REF = null;
        this.RELOAD_GAME_REF = null;
        this.PLACE_WORD_INPUT_REF = null;
    }


    //Constructor that's going to be used.
    public Controller(LaunchGameInputBoundary launchGameInput,
               ReloadGameInputBoundary reloadGameInputBoundary,
               PlaceWordInputBoundary placeWordInputBoundary){
        LAUNCH_GAME_REF = launchGameInput;
        RELOAD_GAME_REF = reloadGameInputBoundary;
        PLACE_WORD_INPUT_REF = placeWordInputBoundary;
    }

    public void launchTheGame(){
        assert LAUNCH_GAME_REF != null;
        LAUNCH_GAME_REF.createGameState();
    }

    public void reloadGame(){
        assert RELOAD_GAME_REF != null;
        RELOAD_GAME_REF.reloadGame();
    }

    public void placeWordExecute(String inputWord){
        if(isOnlyAlphabetString(inputWord)){
            int x = 0; //place hold
            //PLACE_WORD_INPUT_REF.placeWordRefill();
        }

    }
}
