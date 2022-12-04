package CoreEntities.IO;

import launch_new_game_use_case.CreateDictionaryDataAccessObject;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a gateway that accesses a resource file needed to create the Dictionary.
 */

public class DictionaryDataReaderGateway {

    protected ArrayList<String> dictionaryFile;

    public DictionaryDataReaderGateway() throws FileNotFoundException {
        this.dictionaryFile = getFileAsList();
    }

    @NotNull
    protected ArrayList<String> getFileAsList() throws FileNotFoundException {

        String dictFile = "src/main/java/default_reference_values/scrabble_dictionary.txt";
        Scanner s = new Scanner(new File(dictFile));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    public ArrayList<String> getDictionaryFile() throws FileNotFoundException {
        return getFileAsList();


    }
}

