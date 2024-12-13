package ru.itis.service;

import ru.itis.exception.NegativeDataException;

import java.math.BigInteger;
import java.util.Arrays;

public class Combinatoric {

    public static BigInteger getPermutation(int n) {
        validatePositive(n);
        return Factorial.factorial(n);
    }

    public static BigInteger getPermutationWithRepeat(int[] nums) {
        validatePositive(nums);
        int n = Arrays.stream(nums).sum();
        BigInteger numerator = Factorial.factorial(n);
        BigInteger denominator = BigInteger.ONE;
        for (int num : nums) {
            denominator = denominator.multiply(Factorial.factorial(num));
        }
        return numerator.divide(denominator);
    }

    public static BigInteger getPlacement(int n, int k) {
        validatePositive(n, k);
        return Factorial.factorial(n).divide(Factorial.factorial(n - k));
    }

    public static BigInteger getPlacementWithRepeat(int n, int k) {
        validatePositive(n, k);
        BigInteger result = BigInteger.valueOf(n);
        for (int i = 1; i < k; ++i) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }

    public static BigInteger getCombination(int n, int k) {
        validatePositive(n, k);
        return Factorial.factorial(n).divide(Factorial.factorial(n - k).multiply(Factorial.factorial(k)));
    }

    public static BigInteger getCombinationWithRepeat(int n, int k) {
        validatePositive(n, k);
        return Factorial.factorial(n + k - 1).divide(Factorial.factorial(n - 1).multiply(Factorial.factorial(k)));
    }

    private static void validatePositive(int... nums) {
        for (int num : nums) {
            if (num < 0) {
                throw new NegativeDataException("Числа не должны быть отрицательными");
            }
        }
    }

}
