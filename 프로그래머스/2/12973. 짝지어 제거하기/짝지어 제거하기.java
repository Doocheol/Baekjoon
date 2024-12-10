import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        int n = s.length();
        char[] ca = s.toCharArray();
        
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        
        for (int i = 0; i < n; i++) {
            
            char c = ca[i];
            
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
            
        }
        
        
        return stack.isEmpty() ? 1 : 0;
    }
}