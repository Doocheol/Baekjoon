import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int n = board.length;
        int[][] clone = board.clone();
        // for (int i = 0; i < board.length; i++) {
            // clone[i] = System.arrayCopy(board[i]);
        // }
        
        
        Deque<Integer> stack = new LinkedList<>();
        
        
        for (int i = 0; i < moves.length; i++) {
            
            int columnIndex = moves[i] - 1;
            
            for (int j = 0; j < n; j++) {
                
                int value = clone[j][columnIndex];
                
                if (value != 0) {
                    
                    clone[j][columnIndex] = 0;

                    if (!stack.isEmpty() && stack.peek() == value) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(value);
                    }
                    
                    break;
                }
                
                
            }
            
        }
        
        
        return answer;
    }
}