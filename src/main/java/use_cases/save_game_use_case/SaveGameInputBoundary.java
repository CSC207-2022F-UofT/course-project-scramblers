package use_cases.save_game_use_case;

public interface SaveGameInputBoundary {

    /**
     * Saves the current GameState into memory so that it can be reloaded at a later time
     * Returns true or false depending on whether the save was successful
     * @return boolean
     */
    boolean save();

}
