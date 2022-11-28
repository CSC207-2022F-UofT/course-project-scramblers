package io.ui.logic;

import java.util.Observable;

public class ViewModel extends Observable implements PresenterViewModelInterface {
    private String outputText;
    private String [][] boardRepresentation;

    public ViewModel(String [][] input2DStringArray){

        outputText = "";
        boardRepresentation = input2DStringArray;

    }

    @Override
    public void setMessageText(String messageText) {
        this.outputText = messageText;
    }

    @Override
    public void setBoard(String[][] newBoard) {
        this.boardRepresentation = newBoard;
    }
}
