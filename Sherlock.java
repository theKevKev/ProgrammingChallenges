/* Sherlock and the Valid String: 

Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times. Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".

For example, If str = "abc", the string is valid because the frequencies of characters are all the same. If str = "abcc", the string is also valid, because we can remove 1 "c" and have one of each character remaining in the string. However, if str = "abccc", the string is not valid, because removing one character does not result in the same frequency of characters.

Examples
isValid("aabbcd") ➞ "NO"
// We would need to remove two characters, both c and d  -> aabb or a and b -> abcd, to make it valid.
// We are limited to removing only one character, so it is invalid.

isValid("aabbccddeefghi") ➞ "NO"
// Frequency counts for the letters are as follows:
// {"a": 2, "b": 2, "c": 2, "d": 2, "e": 2, "f": 1, "g": 1, "h": 1, "i": 1}
// There are two ways to make the valid string:
// Remove 4 characters with a frequency of 1: {f, g, h, i}.
// Remove 5 characters of frequency 2: {a, b, c, d, e}.
// Neither of these is an option.

isValid("abcdefghhgfedecba") ➞ "YES"
// All characters occur twice except for e which occurs 3 times.
// We can delete one instance of e to have a valid string. */
import java.util.*;

public class Sherlock {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < input.length(); i++){
            char letter = input.charAt(i);
            if(map.containsKey(letter)){
                map.replace(letter, map.get(letter), map.get(letter) + 1);
            }
            else{ // does not contain key
                map.put(letter, 1);
            }
        }
        ArrayList<Integer> counts = new ArrayList<Integer>(map.values());
        System.out.println(counts.toString());
        int max = Collections.max(map.values());
        int min = Collections.min(map.values());
        if(max == min){
            System.out.println("YES, case one");
        }
        else if(max != min + 1){
            System.out.println("NO, case two");
        }
        else{
            int max_counts = 0;
            for(int i = 0; i < counts.size(); i++){
                if(counts.get(i) == max){
                    max_counts++;
                }
            }
            if(max_counts == 1){
                System.out.println("YES, case three");
            } else{
                System.out.println("NO, case four");
            }
        }
        sc.close();
    }
}
