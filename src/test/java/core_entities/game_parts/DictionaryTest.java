package core_entities.game_parts;


import CoreEntities.IO.DictionaryDataReaderGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Set;

class DictionaryTest {
    Dictionary dictionary;
    @BeforeEach
    public void setup() throws FileNotFoundException {
        DictionaryDataReaderGateway dictGate = new DictionaryDataReaderGateway();
        dictionary = new Dictionary(dictGate.getDictionaryFile());
    }






    @Test
    void strToSetTest() {

        String str = "HELLO";
        Set<Character> test; //this is the method we are testing
        test = dictionary.strToSet(str);
        assert test.size() == 4;
        assert test.contains('H');
        assert test.contains('E');
        assert test.contains('L');
        assert test.contains('O');
    }

    @Test
    void getCharacterSetDictionaryTest() {

        String str = "HELLO";
        ArrayList<String> test = dictionary.getCharacterSetDictionary(str);

        assert test.contains("HELLO");
        assert test.contains("HELLHOLE");

    }



}
