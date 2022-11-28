package use_cases.reload_game_use_case;

public interface ReloadGameInputBoundary {

    /**
     * Takes in the saved attributes from a previous version of the GameState
     * and adds them to our current GameState
     * returns true or false depending on whether the GameState was reloaded properly
     * @return boolean
     */
    boolean reloadGame();

}
