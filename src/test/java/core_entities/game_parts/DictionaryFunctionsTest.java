//package core_entities.game_parts;
//
//import CoreEntities.IO.DictionaryDataReaderGateway;
//import CoreEntities.IO.DictionaryDataReaderGatewayTest;
//import core_entities.game_parts.Dictionary;
//import core_entities.game_parts.DictionaryFunctions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DictionaryFunctionsTest {
//    DictionaryFunctions dictionaryFile;
//    @BeforeAll
//    public void setup() throws FileNotFoundException {
//
//        this.dictionaryFile = new Dictionary(DictionaryDataReaderGatewayTest.testDict.getDictionaryFile());
//    }
//
//    @Test
//    void getDictionaryFile() {
//        assert dictionaryFile.getDictionaryFile().size() == 178691;
//    }
//
//    @Test
//    void verifyWord() {
//
//        assert dictionaryFile.verifyWord("HELLO");
//    }
//
//    @Test
//    void getDictionaryMap() {
//        assert dictionaryFile.getDictionaryMap().size() == 26;
//    }
//}