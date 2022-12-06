package take_turn;

public interface TakeTurnOutputBoundary {

    void updateRack(TakeTurnOutputData updateinfo);

    void prepareFailViewAfterExchangingLetters(String cannot_exchange);

    void winning(String winningPlayer);
}
