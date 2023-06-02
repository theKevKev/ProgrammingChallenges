public class StoneGame1Solution {
    public static boolean stoneGame(int[] piles) {
        return stoneGame(piles, 0, true);
    }

    private static boolean stoneGame(int[] piles, int score, boolean isAlice){
        if(piles.length == 0){
            return score > 0 ? true : false;
        }
        int[] pilesL = new int[piles.length - 1];
        int[] pilesR = new int[piles.length - 1];
        System.arraycopy(piles, 1, pilesL, 0, piles.length - 1);
        System.arraycopy(piles, 0, pilesR, 0, piles.length - 1);
        boolean resultL, resultR;
        if(isAlice){
            resultL = stoneGame(pilesL, score + piles[0], !isAlice);
            resultR = stoneGame(pilesR, score + piles[piles.length - 1], !isAlice);
        }
        else{
            resultL = stoneGame(pilesL, score - piles[0], !isAlice);
            resultR = stoneGame(pilesR, score - piles[piles.length - 1], !isAlice);
        }
        return !(resultL && resultR);
    }
}
