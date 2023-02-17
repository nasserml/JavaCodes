
package javaapp;


public class JavaApp {

    public static int sum(int i1 , int i2){
        int result = 0 ; 
        for (int i = i1 ; i < i2 ; i++)
            result += i;
        return result;
    }
   
    public static void main(String[] args) {
        System.out.println(sum(1, 10));
       
    }
    
}
