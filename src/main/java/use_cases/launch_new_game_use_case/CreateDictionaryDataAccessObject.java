package use_cases.launch_new_game_use_case;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface CreateDictionaryDataAccessObject {
    ArrayList<String> getDictionaryFile() throws FileNotFoundException;
}
