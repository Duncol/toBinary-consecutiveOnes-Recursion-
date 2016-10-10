import java.io.*;
import java.util.*;

public class MainClass {
    static String binStr = "";              //Base for building binary equivalent od given decimal number in toBinary()
    
                                            //Variables used in consecutiveOnes()
    static int i = 0;                       // count used to acces specific index of binStr
    static int n = 0;                       // current count of consecutive 1's, n++ if 1st 1 is encountered; resets when 0 is found
    static int maxCount = 0;                // used to store maximum amount of cosecutive 1's in case when incidental 0 resets n, which would be higher than following 1's after that 0, i.e. 11101111
    static boolean isFirstDive = true;      // key to return maxValue instead of n, but still make recursion based on n (makes method to pass specified condition only once)
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sourceNumber = scan.nextInt();
        System.out.println(consecutiveOnes(i, n, toBinary(sourceNumber), isFirstDive)); //Main "thing"
    }
    public static String toBinary(int n){
        if (n==1) {return binStr += "1";}
        else{
            if (n%2==1){
                toBinary(n/2);
                return binStr += "1";
            }
            else{
                toBinary(n/2);
                return binStr += "0";
            }
        }
    }
    public static int consecutiveOnes(int i, int n, String s, boolean iFD){
        if (i == s.length()-1){
            if(s.charAt(i) == '1'){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if (iFD){                                  //First call of method - always
            iFD = false;
            n = consecutiveOnes(i, n, s, iFD);
            return maxCount = Math.max(n, maxCount);
        }
        else{
            if (s.charAt(i) == '1'){
                n = consecutiveOnes(i+1, n, s, iFD);
                return n + 1;
            }
            else{
                n = consecutiveOnes(i+1, n, s, iFD);
                maxCount = Math.max(n, maxCount);
                return 0;
            }
        }
    }
}
