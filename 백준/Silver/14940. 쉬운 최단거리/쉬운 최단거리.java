import java.io.*;
import java.util.*;

public class Main {
    // 그리드의 크기
    static int N, M;
    // 그리드 정보
    static int[][] grid;
    // 각 셀까지의 거리
    static int[][] distance;
    // BFS를 위한 큐
    static Queue<int[]> queue = new LinkedList<>();
    // 상, 하, 좌, 우 이동을 위한 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위한 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄 입력: N (행), M (열)
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그리드와 거리 배열 초기화
        grid = new int[N][M];
        distance = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1); // 초기값은 -1 (방문하지 않음)
        }

        // 시작점의 좌표
        int startX = -1, startY = -1;

        // 그리드 입력 및 시작점 찾기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 2) {
                    startX = i;
                    startY = j;
                    distance[i][j] = 0; // 시작점의 거리는 0
                }
            }
        }

        // 시작점이 존재하지 않는 경우 (문제 조건상 항상 존재한다고 가정)
        if(startX == -1 || startY == -1) {
            // 모든 셀에 대해 출력 (모든 셀이 0이거나 -1)
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(grid[i][j] == 0) {
                        bw.write("0 ");
                    } else {
                        bw.write("-1 ");
                    }
                }
                bw.write("\n");
            }
            bw.flush();
            return;
        }

        // BFS 초기화
        queue.offer(new int[]{startX, startY});

        // BFS 수행
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 4방향 탐색
            for(int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 그리드 범위 내에 있고, 이동 가능하며, 아직 방문하지 않은 경우
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(grid[nx][ny] != 0 && distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j] == 0) {
                    sb.append("0 ");
                } else {
                    sb.append(distance[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
