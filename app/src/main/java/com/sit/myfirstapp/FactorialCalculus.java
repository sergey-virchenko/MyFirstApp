package com.sit.myfirstapp;

import java.math.BigInteger;

public class FactorialCalculus {

    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

    public static BigInteger factorialRec(BigInteger num) {
        if (num.intValue() == 0) return BigInteger.valueOf(1);

        if (num.intValue() == 1) return BigInteger.valueOf(1);

        return num.multiply(factorialRec(num.subtract(BigInteger.valueOf(1))));
    }

}
