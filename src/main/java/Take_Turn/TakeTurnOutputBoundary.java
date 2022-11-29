package Take_Turn;

public interface TakeTurnOutputBoundary {

    void updateBoard(TakeTurnOutputData updateinfo);

    void updateRack(TakeTurnOutputData updateinfo);

    void prepareFailView(String word_cannot_be_placed);
}
