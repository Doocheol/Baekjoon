import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> originalMap = new HashMap<>();
        int n = want.length;
        for (int i = 0; i < n; i++) {
            originalMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> map = new HashMap<>(originalMap);
            for (int j = i; j < i + 10; j++) {
                String discountItem = discount[j];
                
                if (map.containsKey(discountItem)) {
                    map.put(discountItem, map.get(discountItem) - 1);
                    
                    if (map.get(discountItem) == 0) map.remove(discountItem);
                }
                
                
            }
            
            if (map.isEmpty()) answer++;
            
        }
        
        
        return answer;
    }
}