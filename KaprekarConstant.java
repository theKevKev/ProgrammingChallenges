/* Returns the number of interations toward getting Kaprekar's Constant, 6174 */

import java.util.*;

public class KaprekarConstant{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(kaprekar(num));
        input.close();
    }
    private static int kaprekar(int num){
        int count = 0;
        while(num != 6174){
            if(num < 1000) {num *= 10;}
            num = calculateDifference(num);
            count++;
        }
        return count;
    }
    private static int calculateDifference(int num){
        int d = num % 10;
        int c = num / 10 % 10;
        int b = num / 100 % 10;
        int a = num / 1000;
        int[] arrayDigits = new int[] {a,b,c,d}; 
        Arrays.sort(arrayDigits);
        int big = arrayDigits[3] * 1000 + arrayDigits[2] * 100 + arrayDigits[1] * 10 + arrayDigits[0];
        int small = arrayDigits[0] * 1000 + arrayDigits[1] * 100 + arrayDigits[2] * 10 + arrayDigits[3];
        return big - small;
    }
}