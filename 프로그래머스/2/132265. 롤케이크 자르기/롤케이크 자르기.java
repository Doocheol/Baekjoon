import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }
        
        HashSet<Integer> toppingSet = new HashSet<>();
        for (int t : topping) {
            toppingSet.add(t);
            toppingMap.put(t, toppingMap.get(t) - 1);
            
            if (toppingMap.get(t) == 0) toppingMap.remove(t);
            if (toppingMap.size() == toppingSet.size()) answer++;
            
            
        }
        return answer;
    }
}