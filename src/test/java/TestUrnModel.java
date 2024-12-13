import org.junit.Assert;
import org.junit.Test;
import ru.itis.config.Configuration;
import ru.itis.service.UrnModel;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestUrnModel {
    @Test
    public void testSamplingWithoutACertainNumber() {
        BigDecimal a = new BigDecimal("2");
        BigDecimal b = new BigDecimal("5");
        BigDecimal result = a.divide(b, Configuration.SCALE, RoundingMode.HALF_UP);
        Assert.assertEquals(UrnModel.samplingWithoutACertainNumber(5, 4, 3), result);
    }

    @Test
    public void testSamplingWithACertainNumber() {
        BigDecimal a = new BigDecimal("6");
        BigDecimal b = new BigDecimal("10");
        BigDecimal result = a.divide(b, Configuration.SCALE, RoundingMode.HALF_UP);
        Assert.assertEquals(UrnModel.samplingWithACertainNumber(5, 4, 3, 2), result);
    }

}
