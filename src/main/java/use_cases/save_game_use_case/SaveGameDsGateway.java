package use_cases.save_game_use_case;

import core_entities.game_parts.SerializableGameState;

public interface SaveGameDsGateway {

    boolean saveSerializable(SerializableGameState serializableGameState);

}
