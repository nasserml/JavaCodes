package sortcomparableobjects;
import java.math.*;

public class SortComparableObjects {
    public static void main(String[] args) {
        String[] cities = {"Savannah", "Boston", "Atlanta", "Tampa"};
        java.util.Arrays.sort(cities);
        for(String city:cities)
            System.out.print(city + " ");
        System.out.println();
        BigInteger[] hugeNumbers = {new BigInteger("3232323232323"),
        new BigInteger("324242424234"),
        new BigInteger("34324563")};
        java.util.Arrays.sort(hugeNumbers);
        for(BigInteger number:hugeNumbers)
            System.out.print(number + " ");
    }
    
}
