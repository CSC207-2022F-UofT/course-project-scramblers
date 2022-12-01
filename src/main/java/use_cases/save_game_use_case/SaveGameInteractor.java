package use_cases.save_game_use_case;

import core_entities.game_parts.GameState;
import core_entities.game_parts.SerializableGameState;

public class SaveGameInteractor implements SaveGameInputBoundary {

    final SaveGameDsGateway gateway;

    public SaveGameInteractor(SaveGameDsGateway gateway) {
        this.gateway = gateway;
    }

    /**
     * Saves the current GameState into memory so that it can be reloaded at a later time
     * Returns true or false depending on whether the save was successful
     * @return boolean
     */
    @Override
    public boolean save() {

        SerializableGameState serializableGameState = GameState.generateSerializableGameState();
        return gateway.saveSerializable(serializableGameState);

    }
}
