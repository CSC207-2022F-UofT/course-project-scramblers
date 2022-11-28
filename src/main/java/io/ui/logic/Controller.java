package io.ui.logic;

import launch_new_game_use_case.LaunchGameInputBoundary;
import place_word_refill_user_story.PlaceWordInputBoundary;
import use_cases.reload_game_use_case.*;

public class Controller {
    //Should reference every input boundary made
    private final LaunchGameInputBoundary LAUNCH_GAME_REF;
    private final ReloadGameInputBoundary RELOAD_GAME_REF;
    private final PlaceWordInputBoundary PLACE_WORD_INPUT_REF;

    Controller( LaunchGameInputBoundary launchGameInput,
                    ReloadGameInputBoundary reloadGameInputBoundary,
                    PlaceWordInputBoundary placeWordInputBoundary){
        LAUNCH_GAME_REF = launchGameInput;
        RELOAD_GAME_REF = reloadGameInputBoundary;
        PLACE_WORD_INPUT_REF = placeWordInputBoundary;
    }

    public void launchTheGame(){
        LAUNCH_GAME_REF.createGameState();
    }

    public void reloadGame(){
        RELOAD_GAME_REF.reloadGame();
    }

    public void placeWordExecute(){
        //PLACE_WORD_INPUT_REF.placeWordRefill();
    }

    public boolean isOnlyAlphabetString(String inputString){
        if(inputString == null){
            return false;
        }
        return inputString.contains("[a-zA-Z]*");
    }
}
