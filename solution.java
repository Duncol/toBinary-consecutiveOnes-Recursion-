import java.io.*;
import java.util.*;

public class MainClass {
    static String binStr = "";
    static int i = 0;
    static int n = 0;
    static int maxCount = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sourceNumber = scan.nextInt();
        System.out.println(consecutiveOnes(i, n, toBinary(sourceNumber)));
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
    public static int consecutiveOnes(int i, int n, String s){
        if (i == s.length()-1){
            if(s.charAt(i) == '1'){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            if (s.charAt(i) == '1'){
                n = consecutiveOnes(i+1, n, s);         //<<< 1st         <<<2nd
                return n + 1;
            }
            else{
                n = consecutiveOnes(i+1, n, s);         //<<< 3rd
                maxCount = Math.max(n, maxCount);
                n = 0;
                return 0;
            }
        }
    }
}
