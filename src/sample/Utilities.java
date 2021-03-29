package sample;

import java.math.BigInteger;
import java.util.Random;

public class Utilities {
    public static BigInteger getRandomBelow(BigInteger n) {
        BigInteger random = new BigInteger(n.bitLength(), new Random());
        if (random.compareTo(n) < 0) return random;
        return getRandomBelow(n);
    }
}
