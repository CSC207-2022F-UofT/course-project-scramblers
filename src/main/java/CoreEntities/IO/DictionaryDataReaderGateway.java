package CoreEntities.IO;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class DictionaryDataReaderGateway {

    private final String dictFile = "src/resources/scrabble_dictionary.txt";
    ArrayList<String> dictionary;

    public DictionaryDataReaderGateway() throws FileNotFoundException {
        this.dictionary = getFileAsList(dictFile);
    }

    @NotNull
    private static ArrayList<String> getFileAsList() throws FileNotFoundException {
        return getFileAsList(null);
    }

    @NotNull
    private static ArrayList<String> getFileAsList(String dictFile) throws FileNotFoundException {
        Scanner s = new Scanner(new File(dictFile));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    public ArrayList<String> getDictionary() {
        return this.dictionary;
    }
}

