import java.util.*;
import java.io.*;

class Solution {
    
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    private static class Point {
        int y, x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private static int N, M;
    private static char[][] map;
    
    public int solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        Point start = null;
        Point end = null;
        Point lever = null;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') start = new Point(i,j);
                if (map[i][j] == 'E') end = new Point(i,j);
                if (map[i][j] == 'L') lever = new Point(i,j);
            }
        }
        
        int startLever = bfs(start, lever);
        int leverEnd = bfs(lever, end);
        
        if (startLever == -1 || leverEnd == -1) return -1;
        else return startLever + leverEnd;
    
    }
    
    private static int bfs(Point start, Point end) {
        int[][] dist = new int[N][M];
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start.y][start.x] = 1;
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                
                if (!check(ny, nx)) continue;
                if (dist[ny][nx] > 0) continue;
                if (map[ny][nx] == 'X') continue;
                queue.add(new Point(ny, nx));
                dist[ny][nx] = dist[now.y][now.x] + 1;
                if (ny == end.y && nx == end.x) 
                    return dist[end.y][end.x] - 1;
            }
        }
        
        return -1;
    }
    
    private static boolean check(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}