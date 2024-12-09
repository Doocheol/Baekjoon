import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<>();
        // int[] clone = numbers.clone();
        
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] result = set.stream().sorted()
                         .mapToInt(Integer::intValue)
                         .toArray();
        
        // // System.out.println(Arrays.toString(numbers));
        // int[] result = new int[set.size()];
        // Collections.sort(set);
        // for (int i = 0; i < result.length; i++) {
        //     result[i] = set.get(i);
        // }
        
        return result;
        
    }
    
    
        
    
}