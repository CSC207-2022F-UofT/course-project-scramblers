package core_entities.game_parts;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Random;

public class BagTest {
    private final Bag testBag = new Bag();

    @Test
    public void testIsEmpty() {
        for (int i = 0; i < 100; i++){
            testBag.pop();
        }
        assert testBag.isEmpty();
    }

    @Test
    public void testPop() {
        assert testBag.supply.size() != 0;
        int initialSize = testBag.supply.size();
        Tile item = testBag.pop();
        assert item != null;
        assert testBag.supply.size() == initialSize - 1;
    }

    @Test
    public void testPopEmpty() {
        Bag emptyBag = new Bag();
        for (int i = 0; i < 100; i++){
            emptyBag.pop();
        }
        assert emptyBag.isEmpty();
        assert emptyBag.supply.size() == 0;
        assert emptyBag.pop() == null;
    }

    @Test
    public void testDistribute() {
        int initialSize = testBag.supply.size();
        Random random = new Random();
        int length = random.nextInt(Math.floorDiv(initialSize, 2));
        ArrayList<Tile> distributed = testBag.distribute(length);
        assert distributed.size() == length;
        assert testBag.supply.size() == initialSize - length;
    }

    @Test
    public void testAdd() {
        int initialSize = testBag.supply.size();
        testBag.add(new Tile('A', 1));
        assert testBag.supply.size() == initialSize + 1;
    }
}