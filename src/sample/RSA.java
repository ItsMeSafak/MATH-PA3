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
                this.e = random;
                calculateD();
                return random;
            }
        }
    }

    public boolean validateE(BigInteger e) {
        if (e.compareTo(this.n) < 0){
            return Prime.doesNotContainPrimeFactor(e);
        } else {
            return false;
        }
    }

    public BigInteger calculatePHI() {
        this.phi = (this.primes.value1.subtract(BigInteger.ONE).multiply(this.primes.value2.subtract(BigInteger.ONE)));
        return this.phi;
    }

    public BigInteger calculateD() {
        this.d = this.e.modPow(BigInteger.valueOf(-1), calculatePHI());
        return this.d;
    }

    public BigInteger getN() {
        return n;
    }

    public Pair getPrimes() {
        return primes;
    }

    public BigInteger getE() {
        return e;
    }

    public void setE(BigInteger e) {
        this.e = e;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getPhi() {
        return phi;
    }

    @Override
    public String toString() {
        return "RSA{" +
                "n=" + n +
                ", primes=" + primes +
                ", e=" + e +
                ", d=" + d +
                ", phi=" + phi +
                '}';
    }
}
