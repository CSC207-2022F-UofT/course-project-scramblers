package CoreEntities.IO;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

class DictionaryDataReaderGateway {

    private static String dictFile = "src/resources/scrabble_dictionary.txt";
    ArrayList<String> dictionaryfile;

    public DictionaryDataReaderGateway() throws FileNotFoundException {
        this.dictionaryfile = getFileAsList(dictFile);
        Dictionary dictionary = new Dictionary(this.dictionaryfile); {
        }
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

    public ArrayList<String> getDictionaryfile() {
        return this.dictionaryfile;
    }
}

