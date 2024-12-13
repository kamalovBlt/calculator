package ru.itis.service;

import java.math.BigInteger;
import java.util.HashMap;

public class Factorial {
    private static final HashMap<Integer, BigInteger> factorials = new HashMap<>();
    private static int maxCalculatedFactorial = 1;

    static {
        factorials.put(0, BigInteger.ONE);
        factorials.put(1, BigInteger.ONE);
    }

    public static BigInteger factorial(int n) {
        if (factorials.containsKey(n)) {
            return factorials.get(n);
        }

        BigInteger result = factorials.get(maxCalculatedFactorial);
        for (int i = maxCalculatedFactorial + 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
            factorials.put(i, result);
        }

        maxCalculatedFactorial = n;
        return result;
    }
}
