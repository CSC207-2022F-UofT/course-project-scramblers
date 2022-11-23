package use_cases.exchange_rack_letters;
import CoreEntities.Player.HumanPlayer;
import core_entities.game_parts.*;
import org.junit.jupiter.api.*;

public class ExchangeLettersInteractorTest {

    GameState gameState;

    @BeforeEach
    void setup() {
        Bag bagRef = new Bag();
        gameState = new GameState(new HumanPlayer("bob", new LetterRack(bagRef, 7), 0),
                new HumanPlayer("bob2", new LetterRack(bagRef, 7), 0),
                new DefaultBoard());
    }

    /**
     * basic working case
     */
    @Test
    void BaseWorkingCase() {

    }

    /**
     * Exchange all letters
     */
    @Test
    void AllLettersSwap() {

    }

    /**
     * No letters wanted to be swapped so the array is empty.
     */
    @Test
    void NoLetterSwap() {

    }

    /**
     * Some/all letters no present in rack
     */
    @Test
    void LettersNotPresent() {

    }
}
