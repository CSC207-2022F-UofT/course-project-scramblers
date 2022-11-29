package core_entities.game_parts;

import CoreEntities.IO.DictionaryDataReaderGateway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class DictionaryTest {

        private  Dictionary dictionary;

        @BeforeAll
        void setUp() throws FileNotFoundException {
            dictionary = new Dictionary();
        }






    @Test
    void strToSetTest() {
        String str = "hello";
        Set<Character> test; //this is the method we are testing
        test = dictionary.strToSet(str);
        assert test.size() == 4;
        assert test.contains('h');
        assert test.contains('e');
        assert test.contains('l');
        assert test.contains('o');
    }

    @Test
    void getCharacterSetDictionaryTest() {
        String str = "hello";
        ArrayList<String> test;
        test = dictionary.getCharacterSetDictionary(str);
        assert test.size() > 5;
        assert test.contains("hello");
        assert test.contains("he");
        assert test.contains("ho");
        assertFalse(test.contains("zebra"));
    }

    private void assertFalse(boolean x) {
        assert !x;
    }




}
