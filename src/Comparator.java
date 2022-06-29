package excercises;

import java.util.ArrayList;

/**
 * This class does specific actions with numbers, such as tell you if a number is prime or if it's even.
 * @author cristian diaz
 */
public class Comparator {
    
    public static void isEven(int num){
        if(num%2 == 0){
            System.out.println("Is even");
        }
        else{
            System.out.println("Is odd");
        }
    }
    
    public static ArrayList getPrimes(int min, int max){
        int i, j;
        byte count = 0;
        ArrayList data = new ArrayList();
        for(i = min; i < max + 1; i++){
            for(j = 1; j < i + 1; j++){
                if(i%j == 0){
                    count++;
                }
            }
            if(count <= 2){
                data.add(i);
            }
            count = 0;
        }
        return data;
    }
    
    public static void isPrimeNumber(int number){
        if(!getPrimes(number, number).isEmpty()){
            System.out.println("Is prime");
        }
        else{
            System.out.println("Is not prime");
        }
    }
}
