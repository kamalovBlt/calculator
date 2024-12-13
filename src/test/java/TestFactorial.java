import org.junit.Assert;
import org.junit.Test;
import ru.itis.service.Factorial;

import java.math.BigInteger;

public class TestFactorial {
    @Test
    public void testFactorial() {
        Assert.assertEquals(Factorial.factorial(3), BigInteger.valueOf(6));
    }
}
