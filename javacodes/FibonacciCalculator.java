package fibonaccicalculator;
import java.math.BigInteger;

public class FibonacciCalculator {
    
    private static BigInteger TOW = BigInteger.valueOf( 2 );
    
    // recursive declaration of method fibonacci
    public static BigInteger fibonacci( BigInteger number ) {
        if( number.equals( BigInteger.ZERO )  ||
                number.equals( BigInteger.ONE) ) // base case
            return number; 
        else // recursion step
            return fibonacci( number.subtract( BigInteger.ONE ) ).add(
            fibonacci( number.subtract( TOW )));
    }
    
    // display the fibonacci values from 0 - 40
    public static void main(String[] args) {
        for( int counter = 0; counter <= 40; counter++)
            System.out.printf( "Fiboncci of %d is: %d\n", counter,
                    fibonacci( BigInteger.valueOf( counter ) ) );
    }
    
}
