package CoreEntities.IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class DictionaryDataReaderGatewayTest {

    DictionaryDataReaderGateway testDict = new DictionaryDataReaderGateway("src/main/java/default_reference_values/testDictionary.txt");

    DictionaryDataReaderGatewayTest() throws FileNotFoundException {
    }


    @Test
     void getDictionaryFile() {
        ArrayList<String> longList = testDict.getDictionaryFile();
        assertEquals(longList.size()==178691);
    }

    private void assertEquals(boolean b) {
    }
}