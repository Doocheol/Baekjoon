import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] ca = s.toCharArray();
        for (char c : ca) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        
        
        return stack.isEmpty();
//         boolean answer = true;

//         // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//         System.out.println("Hello Java");

        // return answer;
    }
}