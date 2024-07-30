import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int index = 0;
        
        int[] answer = new int[set.size()];
        for (Integer x : set) {
            answer[index++] = x;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    
        
    
}