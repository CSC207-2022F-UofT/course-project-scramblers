package CoreEntities.IO;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class DictionaryDataReaderGatewayTest {

    @Test
    void checkSizeDictionaryFile() throws FileNotFoundException {
        DictionaryDataReaderGateway dictionaryDataReaderGateway = new DictionaryDataReaderGateway();
        ArrayList<String> dictionaryFile = dictionaryDataReaderGateway.getDictionaryFile();
        assert dictionaryFile.size() == 178691;
    }

}