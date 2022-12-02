package io.ui.logic;

import CoreEntities.Player.Player;
import core_entities.game_parts.GameState;

import java.util.Observable;
import java.util.Observer;

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
    public ViewModel(String [][] input2DStringArray){

        this.outputText = "";
        this.boardRepresentation = input2DStringArray;
        this.p1LetterRack = GameState.getP1().getRack().toCharArray();
        this.p2LetterRack = GameState.getP1().getRack().toCharArray();

    }

    /**
     * add an observer to the observer list.
     * @param observer   an observer to be added.
     */
    public void addObserverToViewModel(Observer observer){
        super.addObserver(observer);
    }

    @Override
    public void setMessageText(String messageText) {
        this.outputText = messageText;
        setChanged();
        notifyObservers();
    }

    @Override
    public void setBoard(String[][] newBoard) {
        this.boardRepresentation = newBoard;
        setChanged();
        notifyObservers();
    }

    @Override
    public void updateLetterRacks(){
        this.p1LetterRack = GameState.getP1().getRack().toCharArray();
        this.p2LetterRack = GameState.getP2().getRack().toCharArray();
        setChanged();
        notifyObservers();
    }
}
