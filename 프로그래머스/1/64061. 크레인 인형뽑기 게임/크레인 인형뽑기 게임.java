import java.util.*;
import java.io.*;


class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int n = board.length;
        
        int[][] boardCopy = new int[n][];
        for (int i = 0; i < n; i++) {
            boardCopy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        
        ArrayDeque<Integer>[] lanes = new ArrayDeque[n];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new ArrayDeque<>();
        }
        
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }
        
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        int answer = 0;
        
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move - 1].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }
        
        return answer;
    }
}