package use_cases.take_turn;

public interface TakeTrunInputBoundary {

    /**
     * Call place_word_refill_user_story to try to place the word.
     * If the word can be placed, move to the next turn and show the new board to the user
     * If the word cannot be placed, show error message to the user and ask them to try again
     * If the user attempts three times and still cannot find a valid word, the player is force to exchange tiles with
     * bag in this turn instead. The new rack will be shown to the player and move to the next turn
     */
    void taketurn(TakeTrunInputData inputData);
}
