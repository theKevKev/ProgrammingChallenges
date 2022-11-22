import java.util.*;
public class StringFlipper {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();

        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == ' '){
                result += ' ';
            }
            else if((int) c < 95){
                result += (char) (155 - (int) c);
            }
            else{
                result += (char) (219 - (int) c);
            }
        }
        System.out.println(result);
        input.close();
    } 
}
