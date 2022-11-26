package core_entities.game_parts;

import core_entities.game_parts.dictionary.Dictionary;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class DictionaryTest {


    private ArrayList<String> testDict;

    public DictionaryTest() throws FileNotFoundException {
        String dictFile = "src/test/java/core_entities/game_parts/TestDictionary.txt";
        Scanner s = new Scanner(new File(dictFile));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();

        this.testDict = list;
    }
    @Before
    public void setTestDict() {
        try {
            DictionaryTest start = new DictionaryTest();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }
        Dictionary toTestDict = new Dictionary(this.testDict);
    }

//    @Test
//    void getLongDictionary() {
//        assert testDict.
//    }

    @Test
    void areFormatsTest(){
        ArrayList<String> testVal = Dictionary.getCharacterSetDictionary("A");
        assert testVal.size() == 1;
        assert Objects.equals(testVal.get(0), "A");

    }

    @Test
    void strToSet() {

    }

    @Test
    void getCharacterSetDictionary() {
    }


}