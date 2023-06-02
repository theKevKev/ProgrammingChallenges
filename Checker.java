public class Checker {
    public static void main(String[] args){
        // Test Case 1: 
        int[] piles = new int[]{5,3,4,5};
        System.out.println("Expected: true");
        System.out.println("Recieved: " + StoneGame1Solution.stoneGame(piles));
        
        // Test Case 2: 
        piles = new int[]{3,7,2,3};
        System.out.println("Expected: true");
        System.out.println("Recieved: " + StoneGame1Solution.stoneGame(piles));
    }
}
