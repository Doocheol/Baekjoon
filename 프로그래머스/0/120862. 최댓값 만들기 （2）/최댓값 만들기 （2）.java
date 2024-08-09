import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
       
        Arrays.sort(numbers);
        
        int max = 0;
        max = numbers[0] * numbers[1];
        answer = Math.max(max, numbers[numbers.length - 1] * numbers[numbers.length - 2]);
        
        
        return answer;
    }
}

