// Create a function that returns the sentence that contains the word at index n. Remember to include the full stop at the end. 
// Should account for negative indices as well. 

import java.util.Scanner;
public class StringSearcher2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentence;
        int n;
        do{
            System.out.println("Next sentence?");
            sentence = input.nextLine();
            if(sentence.equalsIgnoreCase("exit"))
                break;
            System.out.println("index of word n?");
            n = input.nextInt();
            input.nextLine();
            System.out.println(stringSearch(sentence, n));
        } while(true);
        input.close();
    }

    private static int findWordIndex(String sentence, int n, boolean isNPositive){
        int i = 0;
        int numOfSpaces = 0;
        if(isNPositive){
            while(numOfSpaces < n){
                if(sentence.charAt(i) == ' '){
                    numOfSpaces++;
                }
                i++;
            }
        }
        else{
            i = sentence.length() - 1;
            while(numOfSpaces < -n){
                if(sentence.charAt(i) == ' '){
                    numOfSpaces++;
                }
                i--;
            }
        }
        // i currently is the index of the first letter of the desired word
        return i;
    }
    private static String stringSearch(String sentence, int n){
        int i = 0;
        if(n < 0){
            i = findWordIndex(sentence,n,false);
        }
        else{
            i = findWordIndex(sentence, n, true);
        }
        
        int indexLow = i;
        while(sentence.charAt(indexLow) != '.' && indexLow != 0){
            indexLow--;
        }
        if(indexLow != 0) // if not first sentence, 
            indexLow += 2; // now indexLow is the first letter of the new sentence
        
        int indexHigh = i;
        while(sentence.charAt(indexHigh) != '.'){
            indexHigh++;
        }

        // while(sentence.charAt(i) != ' '){
        //     phrase += sentence.charAt(i);
        //     i++;
        // }

        return sentence.substring(indexLow, indexHigh + 1);
    }
}