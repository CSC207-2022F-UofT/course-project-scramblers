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
public class DictionaryDataReaderGateway implements CreateDictionaryDataAccessObject {

    private static String dictFile;
    ArrayList<String> dictionaryFile;

    public DictionaryDataReaderGateway(String csvPath) throws FileNotFoundException {
        DictionaryDataReaderGateway.dictFile = csvPath;
        this.dictionaryFile = getFileAsList(dictFile);

    }

    @NotNull
    private static ArrayList<String> getFileAsList() throws FileNotFoundException {
        return getFileAsList(null);
    }

    @NotNull
    private static ArrayList<String> getFileAsList(String dictFile) throws FileNotFoundException {
        DictionaryDataReaderGateway.dictFile = dictFile;
        Scanner s = new Scanner(new File(dictFile));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    public ArrayList<String> getDictionaryFile() {

        return this.dictionaryFile;
    }
}

