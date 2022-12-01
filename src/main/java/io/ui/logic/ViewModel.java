package io.ui.logic;

import CoreEntities.Player.Player;
import core_entities.game_parts.GameState;

import java.util.Observable;

public class ViewModel extends Observable implements PresenterViewModelInterface {
    /**
     * Implements observer and observable design pattern to allow different UIs to be used but the data needed staying,
     * mostly, unchanged.
     */
    private String outputText;
    private String [][] boardRepresentation;
    private char[] p1LetterRack;
    private char[] p2LetterRack;

    /**
     * Constructor for the view model
     * @param input2DStringArray the respresentation of the game board
     */
    public ViewModel(String [][] input2DStringArray, Player p1, Player p2){

        this.outputText = "";
        this.boardRepresentation = input2DStringArray;
        this.p1LetterRack = p1.getRack().toCharArray();
        this.p2LetterRack = p2.getRack().toCharArray();

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

    @Override
    public void updateLetterRacks(){
        setChanged();
        this.p1LetterRack = GameState.getP1().getRack().toCharArray();
        this.p2LetterRack = GameState.getP2().getRack().toCharArray();
        notifyObservers();
    }
}
