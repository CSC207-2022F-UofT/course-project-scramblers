package use_cases.save_game_use_case;

import core_entities.game_parts.GameState;
import core_entities.game_parts.SerializableGameState;

public class SaveGameInteractor implements SaveGameInputBoundary {

    final SaveGameDsGateway gateway;

    public SaveGameInteractor(SaveGameDsGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public boolean save() {

        GameState state = new GameState();
        SerializableGameState serializableGameState = state.generateSerializableGameState();
        return gateway.saveSerializable(serializableGameState);

    }
}
