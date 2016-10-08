import java.io.*;
import java.util.*;

public class Solution {
    static String binStr = "";
    int i = 0;
    int maxCount = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int theNumber = scan.nextInt();
        System.out.println(theNumber = consecutiveOnes(i));
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
    public static int consecutiveOnes(int i){
        if (i == binStr.length()-1){
            if(int n = Integer.parseInt(Character.toString(binStr.charAt(i))) == 1){
                return Math.max(n, maxCount);
            }
            else{
                return Math.max(n = 0, maxCount-1);
            }
        }
        else{
            if (binStr.charAt(i) == '1'){
                consecutiveOnes(i+1);
                n += 1;
                return Math.max(n, maxCount);
            }
            else{
                return Math.max(n, maxCount);
            }
        }                  
    }
}
