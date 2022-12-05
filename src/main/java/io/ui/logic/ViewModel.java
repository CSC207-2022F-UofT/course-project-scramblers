package io.ui.logic;

import core_entities.game_parts.GameState;
import io.*;

public class ViewModel implements PresenterViewModelInterface {
    /**
     * Implements observer and observable design pattern to allow different UIs to be used but the data needed staying,
     * mostly, unchanged.
     */
    private String outputText;
    private String [][] boardRepresentation;
    private char[] displayRack;
    private final ViewFinal VIEW_FINAL_REF;
    private String errorText;

    /**
     * Constructor for the view model
     * @param input2DStringArray the respresentation of the game board
     */
    public ViewModel(String [][] input2DStringArray, ViewFinal inputView){

        this.outputText = "";
        this.errorText = "";
        this.boardRepresentation = input2DStringArray;
        this.displayRack = null;
        this.VIEW_FINAL_REF = inputView;

    }

    @Override
    public void setErrorText(String inputErrorString){
        this.errorText = inputErrorString;
    }

    @Override
    public void setMessageText(String messageText) {
        this.outputText = messageText;
    }

    @Override
    public void setBoard(String[][] newBoard) {
        this.boardRepresentation = newBoard;
    }

    @Override
    public void setBoard(char[][] newBoard){
        this.boardRepresentation = convertCharToStringArrays(newBoard);
    }

    @Override
    public void updateDisplayLetterRack(){
        this.displayRack = GameState.getCurrentPlayer().getRack().toCharArray();
    }

    /**
     * Convert a 2d Char array to it's String equivalent
     * @param input2DCharArray is a n by n 2d array
     * @return the string[][] equivalent
     */
    private String[][] convertCharToStringArrays(char[][] input2DCharArray){
        String[][] output = new String[input2DCharArray.length][input2DCharArray[0].length];
        for(int x = 0; x < input2DCharArray.length; x++){
            for(int y = 0; y < input2DCharArray.length; y++){
                output[x][y] = "" + input2DCharArray[x][y];
            }
        }

        return output;
    }
}
