package CoreEntities.IO;


import org.junit.Before;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class DictionaryDataReaderGatewayTest {
    DictionaryDataReaderGateway testDict;
  @Before
    public void setup() throws FileNotFoundException {
        testDict = new DictionaryDataReaderGateway();

    }
    


    @Test
    void checkSizeDictionaryFile() throws FileNotFoundException {

        ArrayList<String> dictionaryFile = testDict.getDictionaryFile();
        assert dictionaryFile.size() == 178691;
    }

}