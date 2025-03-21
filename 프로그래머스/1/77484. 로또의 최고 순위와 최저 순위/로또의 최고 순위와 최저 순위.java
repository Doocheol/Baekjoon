import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> win = new HashSet<>();
        for (int winNum : win_nums) {
            win.add(winNum);
        }
        
        int zeroNum = 0, match = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zeroNum++;
            else if (win.contains(lotto)) match++;
        }
        
        return new int[]{7 - Math.max((match + zeroNum), 1), 7 - Math.max(match, 1)};
    
    }
}