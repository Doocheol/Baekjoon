import java.util.*;

class Solution {
    
    private static class Node{
        int i, j, cost;
        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int n = land.length;
        boolean[][] visited = new boolean[n][n];
        
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.add(new Node(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.i][now.j]) continue;
            visited[now.i][now.j] = true;
            answer += now.cost;
            
            for (int d = 0; d < 4; d++) {
                int nr = now.i + dr[d];
                int nc = now.j + dc[d];
                
                if(!(0<=nr && nr <n && 0<=nc && nc < n)) continue;
                int tempCost = Math.abs(land[now.i][now.j] - land[nr][nc]);
                int newCost = tempCost > height ? tempCost : 0;
                pq.add(new Node(nr, nc, newCost));
            }
        }
        
        
        
        
        return answer;
    }
}