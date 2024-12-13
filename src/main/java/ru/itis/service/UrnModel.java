package ru.itis.service;

import ru.itis.config.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UrnModel {
    public static BigDecimal samplingWithoutACertainNumber(int n, int m, int k) {
        BigDecimal a = new BigDecimal(Combinatoric.getCombination(m, k));
        BigDecimal b = new BigDecimal(Combinatoric.getCombination(n, k));
        return a.divide(b, Configuration.SCALE, RoundingMode.HALF_UP);
    }
    public static BigDecimal samplingWithACertainNumber(int n, int m, int k, int r) {
        BigDecimal a = new BigDecimal(Combinatoric.getCombination(m, r));
        BigDecimal b = new BigDecimal(Combinatoric.getCombination(n - m, k - r));
        BigDecimal c = new BigDecimal(Combinatoric.getCombination(n, k));
        return a.multiply(b).divide(c, Configuration.SCALE, RoundingMode.HALF_UP);
    }
}

