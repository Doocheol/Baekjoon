import java.util.*;

class Solution {
    
    private static int[][] computer;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        computer = computers;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
            
        }
        
        return answer;
    }
    
    private static void dfs(int now) {
        visited[now] = true;
        for (int i = 0; i < computer[now].length; i++) {
            if (computer[now][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}