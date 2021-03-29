package sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Prime {
    private static final int PRIME_MINIMUM = 2;
    private static final int BIGINTEGER_DIVIDE_INDEX = 0;
    private static final int BIGINTEGER_REMAINDER_INDEX = 1;

    public static Pair getPrimes(BigInteger n) {
        for (BigInteger i = BigInteger.valueOf(PRIME_MINIMUM);
             i.compareTo(n) < 0;
             i = i.add(BigInteger.ONE))
        {
            BigInteger[] result = n.divideAndRemainder(i);

            if (result[BIGINTEGER_REMAINDER_INDEX].equals(BigInteger.ZERO)) {
                return new Pair(result[BIGINTEGER_DIVIDE_INDEX], i);
            }
        }

        return new Pair(n, BigInteger.ZERO);
    }

    public static boolean doesNotContainPrimeFactor(BigInteger n) {
        List<BigInteger> primes = Arrays.asList(
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(7),
                BigInteger.valueOf(13)
        );

        for (BigInteger bigint : primes) {
            BigInteger[] result = n.divideAndRemainder(bigint);
            if (result[1].equals(BigInteger.ZERO)) {
                return false;
            }
        }

        return true;
    }
}
