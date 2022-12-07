package CoreEntities.IO;


import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class DictionaryDataReaderGatewayTest {
    static DictionaryDataReaderGateway testDict;
  @BeforeAll
    public static void setup() throws FileNotFoundException {
        testDict = new DictionaryDataReaderGateway("src/main/java/default_reference_values/scrabble_dictionary.txt");

    }

    @Test
    void checkSizeDictionaryFile() {
        ArrayList<String> dictionaryFile = testDict.getDictionaryFile();
        assert dictionaryFile.size() == 178691;
    }

}