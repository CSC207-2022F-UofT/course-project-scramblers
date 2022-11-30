package io.ui.logic;

public interface PresenterViewModelInterface {

    /**
     * Set the output message
     * @param messageText message to be displayed
     */
    void setMessageText(String messageText);

    /**
     * representation of the board
     * @param newBoard the new board state.
     */
    void setBoard(String[][] newBoard);

    /**
     * Update the LetterRacks due to a change
     */
    void updateLetterRacks();
}
