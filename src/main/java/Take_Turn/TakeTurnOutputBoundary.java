package Take_Turn;

public interface TakeTurnOutputBoundary {

    void updateRack(TakeTurnOutputData updateinfo);

    void prepareFailView(String cannot_exchange);
}
