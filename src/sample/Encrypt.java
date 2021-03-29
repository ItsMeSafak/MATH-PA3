package sample;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Encrypt {
    public static List<BigInteger> encryptMessage(String m, BigInteger n, BigInteger e) {
        List<BigInteger> result = new ArrayList<>();
        byte[] mBytes = m.getBytes(StandardCharsets.UTF_8);

        for (byte b : mBytes) {
            result.add(BigInteger.valueOf(b).modPow(e, n));
        }

        return result;
    }
}
