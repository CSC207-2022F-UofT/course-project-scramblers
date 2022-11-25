package use_cases.launch_new_game_use_case;

import java.io.IOException;

public interface LaunchGameDataAccessObject {
    String [][] createBoardMultiplierGrid() throws IOException;
}
