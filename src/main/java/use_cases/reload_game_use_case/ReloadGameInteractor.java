package use_cases.reload_game_use_case;

import core_entities.game_parts.GameState;
import use_cases.save_game_use_case.SaveGameDsGateway;

public class ReloadGameInteractor implements ReloadGameInputBoundary {

    final ReloadGameDsGateway gateway;

    public ReloadGameInteractor(ReloadGameDsGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public boolean reloadGame(ReloadGameDsGateway gateway) {
        ReloadGameDsResponseModel model = gateway.reload();
        if (model != null) {
            GameState state = new GameState();
            state.setP1(model.getP1());
            state.setP2(model.getP2());
            state.setBoard((model.getBoard()));
            return true;
        } else {
            return false;
        }
    }
}
