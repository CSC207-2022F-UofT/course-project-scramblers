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

    protected ArrayList<String> dictionaryFile;

    public DictionaryDataReaderGateway() throws FileNotFoundException {
        this.dictionaryFile = getFileAsList("src/main/java/default_reference_values/scrabble_dictionary.txt");
    }

    public DictionaryDataReaderGateway(String fileLocation) throws FileNotFoundException {
        this.dictionaryFile = getFileAsList(fileLocation);
    }



    protected ArrayList<String> getFileAsList(String fileLocation) throws FileNotFoundException {


        return getStrings(fileLocation);
    }

    @NotNull
    private ArrayList<String> getStrings(String fileLocation) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileLocation));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    @Override
    public ArrayList<String> getDictionaryFile() {
        return dictionaryFile;


    }
}


