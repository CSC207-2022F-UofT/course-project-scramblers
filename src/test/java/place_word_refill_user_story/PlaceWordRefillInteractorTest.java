package place_word_refill_user_story;

import CoreEntities.Player.ComputerPlayer;
import CoreEntities.Player.HumanPlayer;
import core_entities.game_parts.*;
import default_reference_values.DefaultBoardDataAccessObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceWordRefillInteractorTest {

    @Test
    void placeWordEmptyBoard() {
        DefaultBoardDataAccessObject dataAccessObject = new DefaultBoardDataAccessObject("board-data.csv");
        Bag bag = new Bag();
        Board board;
        try {
            board = new DefaultBoardFactory().create(dataAccessObject.createBoardMultiplierGrid());
        } catch (Exception IOException) {
            fail(); // Board creation not expected to fail
            return;
        }
        HumanPlayer humanPlayer = new HumanPlayer("human", new LetterRack(bag, 7), 0);
        ComputerPlayer computerPlayer = new ComputerPlayer("computer", new LetterRack(bag, 7), 0);
        SerializableGameState gameState = new SerializableGameState(humanPlayer, computerPlayer, board);
        // TODO: finish this test and more
    }
}