package CoreEntities.GameParts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Random;

public class BagTest {
    private final Bag testBag = new Bag();

    @Test
    public void doesTestingWork() {
        String helloString = "Hello World";
        Assertions.assertEquals(helloString, "Hello World");
    }

    @Test
    public void testIsEmpty() {
        for (int i = 0; i < 100; i++){
            testBag.pop();
        }
        boolean result = testBag.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void testPop() {
        int initialSize = testBag.supply.size();
        Tile item = testBag.pop();
        assert item instanceof Tile;
        assert testBag.supply.size() == initialSize - 1;
    }

    @Test
    public void testDistribute() {
        int initialSize = testBag.supply.size();
        Random random = new Random();
        int length = random.nextInt(initialSize);
        ArrayList<Tile> distributed = testBag.distribute(length);
        int i = 1;
        for (Tile t: distributed){
            assert t instanceof Tile;
            i++;
        }
        assert i == length;
        assert testBag.supply.size() == initialSize - length;
    }

    @Test
    public void testAdd() {
        int initialSize = testBag.supply.size();
        testBag.add(new Tile('A', 1));
        assert testBag.supply.size() == initialSize + 1;
    }
}