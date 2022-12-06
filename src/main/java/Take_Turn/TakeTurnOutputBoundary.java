package Take_Turn;

import CoreEntities.Player.Player;

public interface TakeTurnOutputBoundary {

    void updateRack(TakeTurnOutputData updateinfo);

    void prepareFailView(String cannot_exchange);

    void winning(String winningPlayer);
}
