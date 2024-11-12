import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    static int[][] map;

    // 파이프의 방향: 0 = 가로, 1 = 세로, 2 = 대각선
    static class Pipe {
        int x, y, direction;

        Pipe(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1]; // 1-based indexing
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(bfs());
    }

    static long bfs() {
        Deque<Pipe> queue = new ArrayDeque<>();
        queue.add(new Pipe(1, 2, 0)); // 초기 상태: (1,2)에서 가로 방향
        long count = 0;
        
        while (!queue.isEmpty()) {
            Pipe current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dir = current.direction;
            
            // 목표 위치에 도착했을 때
            if (x == N && y == N) {
                count++;
                continue;
            }
            
            // 가능한 모든 이동을 시도
            // 1. 가로 이동
            if (dir == 0 || dir == 2) { // 현재 가로 또는 대각선 방향일 때
                if (y + 1 <= N && map[x][y + 1] == 0) {
                    queue.add(new Pipe(x, y + 1, 0));
                }
            }
            
            // 2. 세로 이동
            if (dir == 1 || dir == 2) { // 현재 세로 또는 대각선 방향일 때
                if (x + 1 <= N && map[x + 1][y] == 0) {
                    queue.add(new Pipe(x + 1, y, 1));
                }
            }
            
            // 3. 대각선 이동
            if (x + 1 <= N && y + 1 <= N &&
                map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                queue.add(new Pipe(x + 1, y + 1, 2));
            }
        }
        
        return count;
    }
}
