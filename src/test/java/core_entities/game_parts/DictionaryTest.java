package core_entities.game_parts;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import java.util.Set;

class DictionaryTest {
    Dictionary dictionary;
    @BeforeEach
    public void setup() {
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

        String str = "HELLO";
        ArrayList<String> test = dictionary.getCharacterSetDictionary(str);

        assert test.contains("HELLO");
        assert test.contains("HELLHOLE");

    }



}
