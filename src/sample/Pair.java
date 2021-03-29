package sample;

import java.math.BigInteger;

public class Pair {
    BigInteger value1;
    BigInteger value2;

    public Pair(BigInteger value1, BigInteger value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
