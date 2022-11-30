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

    //Constructor that's going to be used.
    Controller(LaunchGameInputBoundary launchGameInput,
               ReloadGameInputBoundary reloadGameInputBoundary,
               PlaceWordInputBoundary placeWordInputBoundary){
        LAUNCH_GAME_REF = launchGameInput;
        RELOAD_GAME_REF = reloadGameInputBoundary;
        PLACE_WORD_INPUT_REF = placeWordInputBoundary;
    }

    public void launchTheGame(){
        LaunchGameRequestModel requestModel = new LaunchGameRequestModel("Human Player", "Human Player", "Player 1", "Player 2");
        LAUNCH_GAME_REF.createGameState(requestModel);
    }

    public void reloadGame(){
        RELOAD_GAME_REF.reloadGame();
    }

    public void placeWordExecute(String inputWord){
        if(isOnlyAlphabetString(inputWord)){
            int x = 0; //place hold
            //PLACE_WORD_INPUT_REF.placeWordRefill();
        }

    }

    public boolean isOnlyAlphabetString(String inputString){
        if(inputString == null){
            return false;
        }
        return Pattern.matches("[a-zA-Z]*", inputString);
    }
}
