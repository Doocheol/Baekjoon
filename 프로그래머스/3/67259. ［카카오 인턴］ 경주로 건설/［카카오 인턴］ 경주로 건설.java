import java.util.*;

class Solution {
    
    private static class Node {
        int x, y, direction, cost;
        public Node(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    private static final int[] dx = {0, -1, 0, 1};
    private static final int[] dy = {-1, 0, 1, 0};
    private static int N;
    private static int[][][] visited;
    
    
    private static boolean isValid(int x, int y) {
        return 0<=x && x<N && 0<=y && y < N;
    }
    
    private static boolean isBlocked(int[][] board, int x, int y) {
        return (x == 0 && y == 0) || !isValid(x, y) || board[x][y] == 1;
    }
    
    private static int calculateCost(int direction, int prevDirection, int cost) {
        if (prevDirection == -1 || (prevDirection - direction) % 2 == 0) return cost + 100;
        return cost + 600;
    }
    
    private static boolean isShouldUpdate(int x, int y, int direction, int newCost) {
        return visited[x][y][direction] == 0 || visited[x][y][direction] > newCost;
    }
    
    public int solution(int[][] board) {
        
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));
        N = board.length;
        visited = new int[N][N][4];
        int answer = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if (isBlocked(board, nx, ny)) continue;
                int newCost = calculateCost(d, now.direction, now.cost);
                
                if (nx == N - 1 && ny == N - 1) answer = Math.min(answer, newCost);
                else if (isShouldUpdate(nx, ny, d, newCost)) {
                    queue.add(new Node(nx, ny, d, newCost));
                    visited[nx][ny][d] = newCost;
                }
            }            
        }
        
        return answer;
        
    }
}