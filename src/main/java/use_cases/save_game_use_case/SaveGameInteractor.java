package use_cases.save_game_use_case;

import core_entities.game_parts.GameState;
import core_entities.game_parts.SerializableGameState;

public class SaveGameInteractor implements SaveGameInputBoundary {

    final SaveGameDsGateway gateway;
    final SaveGameOutputBoundary presenter;

    public SaveGameInteractor(SaveGameDsGateway gateway, SaveGameOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     * Saves the current GameState into memory so that it can be reloaded at a later time
     * Returns true or false depending on whether the save was successful
     * @return boolean
     */
    @Override
    public boolean save() {

        SerializableGameState serializableGameState = GameState.generateSerializableGameState();

        if (gateway.saveSerializable(serializableGameState)) {
            this.presenter.updateViewModel("Game saved successfully");
            return true;
        } else {
            this.presenter.prepareFailView("Could not save");
            return false;
        }

    }
}
