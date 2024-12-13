import org.junit.Assert;
import org.junit.Test;
import ru.itis.exception.NegativeDataException;
import ru.itis.service.Combinatoric;

import java.math.BigInteger;

public class TestCombinatoric {
    @Test
    public void testGetPermutationsWithRepeatRandomData() {
        Assert.assertEquals(Combinatoric.getPermutationWithRepeat(new int[]{2, 2, 1}), BigInteger.valueOf(30));
    }
    @Test
    public void testGetPermutationsWithRepeatNullData() {
        Assert.assertEquals(Combinatoric.getPermutationWithRepeat(new int[]{0, 0, 0}), BigInteger.valueOf(1));
    }

    @Test
    public void testGetPermutationsWithRepeat001Data() {
        Assert.assertEquals(Combinatoric.getPermutationWithRepeat(new int[]{0, 0, 1}), BigInteger.valueOf(1));
    }

    @Test(expected = NegativeDataException.class)
    public void testGetPermutationsWithRepeatMinusData() {
        Combinatoric.getPermutationWithRepeat(new int[]{0, 0, -1});
    }
    @Test
    public void testGetPermutationsZeroData() {
        Assert.assertEquals(Combinatoric.getPermutation(0), BigInteger.valueOf(1));
    }

    @Test
    public void testGetPlacementRandomData() {
        Assert.assertEquals(Combinatoric.getPlacement(5, 3), BigInteger.valueOf(60));
    }

    @Test
    public void testGetPlacementZeroData() {
        Assert.assertEquals(Combinatoric.getPlacement(0, 0), BigInteger.valueOf(1));
    }

    @Test
    public void testGetPlacementWithRepeatRandomData() {
        Assert.assertEquals(Combinatoric.getPlacementWithRepeat(5, 3), BigInteger.valueOf(125));
    }
    @Test
    public void testGetPlacementWithRepeatZeroData() {
        Assert.assertEquals(Combinatoric.getPlacementWithRepeat(0, 3), BigInteger.valueOf(0));
    }

    @Test
    public void testGetCombinationsRandomData() {
        Assert.assertEquals(Combinatoric.getCombination(10, 4), BigInteger.valueOf(210));
    }

    @Test
    public void testGetCombinationsZeroData() {
        Assert.assertEquals(Combinatoric.getCombination(0, 0), BigInteger.valueOf(1));
    }

    @Test
    public void testGetCombinationsWithRepeatRandomData() {
        Assert.assertEquals(Combinatoric.getCombinationWithRepeat(5, 3), BigInteger.valueOf(35));
    }

}
