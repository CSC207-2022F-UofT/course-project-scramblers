package use_cases.take_turn;

public interface TakeTurnOutputBoundary {

    void updateRack(TakeTurnOutputData updateinfo);

    void updateOnlyRack(TakeTurnOutputData updateInfo);

    void prepareFailViewAfterExchangingLetters(String cannot_exchange);

    void winning(String winningPlayer);
}
