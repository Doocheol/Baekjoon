import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        boolean answer = true;
        
        ArrayDeque<String> queue1 = new ArrayDeque<>();
        ArrayDeque<String> queue2 = new ArrayDeque<>();
        ArrayDeque<String> queue3 = new ArrayDeque<>();
        
        int n = goal.length;
        
        for (int i = 0; i < n; i++) {
            queue1.offer(goal[i]);
        }
        
        for (int i = 0; i < cards1.length; i++) {
            queue2.offer(cards1[i]);
        }
        
        for (int i = 0; i < cards2.length; i++) {
            queue3.offer(cards2[i]);
        }
        
        while (!queue1.isEmpty()) {
            
            String goalPeek = queue1.peek();
            String cards1Peek = queue2.peek();
            String cards2Peek = queue3.peek();
            
            if (goalPeek.equals(cards1Peek)) {
                queue1.pop();
                queue2.pop();
            }
            else if (goalPeek.equals(cards2Peek)) {
                queue1.pop();
                queue3.pop();
            }
            else {
                answer = false;
                break;
            }
            
        }
        
        return answer ? "Yes" : "No";
    }
}