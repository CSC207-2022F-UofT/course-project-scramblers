package use_cases.save_game_use_case;

import core_entities.game_parts.SerializableGameState;

public interface SaveGameDsGateway {

    /**
     * Attempts to save the serializable version of GameState into a file for persistence
     * @param serializableGameState SerializableGameState
     * @return boolean
     */
    boolean saveSerializable(SerializableGameState serializableGameState);

}
