package testrationalclass;
public class Rational extends Number implements Comparable<Rational> {
    // Date fields for numerator and denominator
    private long numerator = 0;
    private long denominator = 1;
    
    // Construct a rational with default properties
    public Rational() {
        this(0, 1);
    }
    
    // Construct a rational with specified numerator and deniminator
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    // Finf GCD of tow numbers
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;
        
        for(int k = 1; k <= n1 && k <= n2; k++){
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }
        
        return gcd;
    }
    
    // Returtn numerator
    public long getNumerator() {
        return numerator;
    }
    
    // Return denominator
    public long getDenominator() {
        return denominator;
    }
    
    // Add a rational number to this rational
    public Rational add(Rational secondRational) {
        long n = numerator * secondRational.getDenominator() +
                denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    // Subtract a rational number from this rational
    public Rational subtract(Rational secondRational) {
        
    }
    
}
