package io.ui.logic;

import core_entities.game_parts.Coordinate;
import core_entities.game_parts.GameState;
import launch_new_game_use_case.*;
import take_turn.*;
import use_cases.reload_game_use_case.*;

public class Controller {
    //Should reference every input boundary made
    private final LaunchGameInputBoundary LAUNCH_GAME_REF;
    private final ReloadGameInputBoundary RELOAD_GAME_REF;
    private final TakeTrunInputBoundary TAKE_TURN_INPUT_REF;


    //Constructor that's going to be used.
    public Controller(LaunchGameInputBoundary launchGameInput,
               ReloadGameInputBoundary reloadGameInputBoundary,
               TakeTrunInputBoundary takeTrunInputBoundary){
        this.LAUNCH_GAME_REF = launchGameInput;
        this.RELOAD_GAME_REF = reloadGameInputBoundary;
        this.TAKE_TURN_INPUT_REF = takeTrunInputBoundary;
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

    /**
     * Take an action given in an input (-1,-1) for exchanging letters and place a word otherwise.
     * @param inputWord the input word
     * @param startX the start coordinate
     * @param startY the end coordinate
     */
    public void executeTurn(String inputWord, String startX, String startY) {
        if(!(startX.contains("[a-zA-Z]") || startY.contains("[a-zA-Z]"))){
            int startXInt = Integer.parseInt(startX);
            int startYInt = Integer.parseInt(startY);
            if(startXInt == -1 && startYInt == -1){
                TAKE_TURN_INPUT_REF.taketurn(new TakeTrunInputData(inputWord,
                        new Coordinate(startXInt, startXInt),
                        new Coordinate(0, 0)));
            }
            else if(startXInt + inputWord.length() < GameState.getBoard().getLetterGrid().length){
                TAKE_TURN_INPUT_REF.taketurn(new TakeTrunInputData(inputWord,
                        new Coordinate(startXInt, startYInt),
                        new Coordinate(startXInt + inputWord.length(), startYInt)));
            }
            else if(startYInt + inputWord.length() < GameState.getBoard().getLetterGrid().length){
                TAKE_TURN_INPUT_REF.taketurn(new TakeTrunInputData(inputWord,
                        new Coordinate(startXInt, startYInt),
                        new Coordinate(startXInt, startYInt + inputWord.length())));
            }

        }
    }
}
