package launch_new_game_use_case;

import core_entities.game_parts.BoardFactory;
import core_entities.game_parts.GameState;

public class LaunchNewGameInteractor implements LaunchGameInputBoundary{
    private final BoardFactory factory;
    private final LaunchGameOutputBoundary presenter;
    public LaunchNewGameInteractor (BoardFactory factory, LaunchGameOutputBoundary presenter) {
        this.factory = factory;
        this.presenter = presenter;
    }
    @Override
    public void createGameState() {
        GameState.setBoard(factory.create());
        //add players to game state
        presenter.updateViewModel(GameState.getBoard().getMultiplierGrid());
    }
}
