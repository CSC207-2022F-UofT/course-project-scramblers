package io.ui.logic;

import java.util.Observable;

public class ViewModel extends Observable implements PresenterViewModelInterface {
    private String outputText;
    private String [][] boardRepresentation;

    /**
     * Constructor for the view model
     * @param input2DStringArray the respresentation of the game board
     */
    public ViewModel(String [][] input2DStringArray){

        outputText = "";
        boardRepresentation = input2DStringArray;
        notifyAll();

    }

    @Override
    public void setMessageText(String messageText) {
        this.outputText = messageText;
        notifyAll();
    }

    @Override
    public void setBoard(String[][] newBoard) {
        this.boardRepresentation = newBoard;
        notifyAll();
    }
}
