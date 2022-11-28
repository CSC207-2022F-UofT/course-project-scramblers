package use_cases.reload_game_use_case;

import core_entities.game_parts.GameState;
import use_cases.save_game_use_case.SaveGameDsGateway;

public class ReloadGameInteractor implements ReloadGameInputBoundary {

    final ReloadGameDsGateway gateway;

    public ReloadGameInteractor(ReloadGameDsGateway gateway) {
        this.gateway = gateway;
    }

    /**
     * Takes in the saved attributes from a previous version of the GameState
     * and adds them to our current GameState
     *
     * @return boolean
     */
    @Override
    public boolean reloadGame() {
        ReloadGameDsResponseModel model = this.gateway.reload();
        if (model != null) {
            GameState.setP1(model.getP1());
            GameState.setP2(model.getP2());
            GameState.setBoard((model.getBoard()));
            return true;
        } else {
            return false;
        }
    }
}
