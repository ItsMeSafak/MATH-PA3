package sample;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Decrypt {
    public static String decryptMessage(List<BigInteger> m, BigInteger n, BigInteger d) {
        StringBuilder msg = new StringBuilder();
        for (BigInteger b : m) {
            BigInteger a = b.modPow(d, n);
            msg.append(new String(a.toByteArray(), StandardCharsets.UTF_8));
        }
        return msg.toString();
    }
}
