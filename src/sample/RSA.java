package sample;

import java.math.BigInteger;

public class RSA {

    private BigInteger n;
    private Pair primes;
    private BigInteger e;
    private BigInteger d;
    private BigInteger phi;

    public RSA(BigInteger n) {
        this.n = n;
        this.primes = Prime.getPrimes(n);
        this.e = calculateE();
        this.phi = calculatePHI();
        this.d = calculateD();
    }

    public BigInteger calculateE() {
        while (true) {
            BigInteger random = Utilities.getRandomBelow(this.n);
            if (Prime.doesNotContainPrimeFactor(random)) {
                System.out.println("e is " + random);
                return random;
            }
        }
    }

    public BigInteger calculatePHI() {
        return (this.primes.value1.subtract(BigInteger.ONE).multiply(this.primes.value2.subtract(BigInteger.ONE)));
    }

    public BigInteger calculateD() {
        return this.e.modPow(BigInteger.valueOf(-1), calculatePHI());
    }
}
