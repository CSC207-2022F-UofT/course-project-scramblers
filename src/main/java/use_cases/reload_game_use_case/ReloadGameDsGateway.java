package use_cases.reload_game_use_case;

public interface ReloadGameDsGateway {

    /**
     * Checks the state.txt file which should have a serializable version of GameState and returns the
     * relevant information
     * @return ReloadGameDsResponseModel
     */
    ReloadGameDsResponseModel reload();

}
