package io.ui.logic;

import java.util.Observable;

public class ViewModel extends Observable implements PresenterViewModelInterface {
    /**
     * Implements observer and observable design pattern to allow different UIs to be used but the data needed staying,
     * mostly, unchanged.
     */
    private String outputText;
    private String [][] boardRepresentation;

    /**
     * Constructor for the view model
     * @param input2DStringArray the respresentation of the game board
     */
    public ViewModel(String [][] input2DStringArray){

        outputText = "";
        boardRepresentation = input2DStringArray;

    }

    @Override
    public void setMessageText(String messageText) {
        setChanged();
        this.outputText = messageText;
        notifyObservers();
    }

    @Override
    public void setBoard(String[][] newBoard) {
        setChanged();
        this.boardRepresentation = newBoard;
        notifyObservers();
    }
}
