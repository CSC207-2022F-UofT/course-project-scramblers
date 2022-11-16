package core_entities.game_parts;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

class DictionaryTest {

    Dictionary testDict = new Dictionary();

    DictionaryTest() throws FileNotFoundException {
    }

//    @Test
//    void getLongDictionary() {
//        assert testDict.
//    }

    @Test
    void areFormatsTest(){
        ArrayList<String> testVal = testDict.getCharacterSetDictionary("A");
        assert testVal.size() == 1;
        assert Objects.equals(testVal.get(0), "A");

    }

//    @Test
//    void getCharacterSetDictionary() {
//    }
}