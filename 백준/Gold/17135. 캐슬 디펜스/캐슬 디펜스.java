import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D;
    static int[][] originalGrid;
    static int maxKills = 0;
    static int[] archers = new int[3];
    static int[] dx = {0, -1, 0}; // 왼쪽, 위, 오른쪽
    static int[] dy = {-1, 0, 1};

    // Point 클래스 정의
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        // equals 메소드 오버라이드
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        // hashCode 메소드 오버라이드
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        originalGrid = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                originalGrid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 궁수 배치 조합 생성
        combination(0, 0, new int[3]);

        System.out.println(maxKills);
    }

    // 궁수 배치 조합 생성 함수
    static void combination(int start, int depth, int[] selected) {
        if(depth == 3) {
            // 선택된 궁수 배치로 시뮬레이션 수행
            simulate(selected);
            return;
        }

        for(int i=start; i<M; i++) {
            selected[depth] = i;
            combination(i+1, depth+1, selected);
        }
    }

    // 시뮬레이션 함수
    static void simulate(int[] selectedArchers) {
        // 원본 그리드 깊은 복사
        int[][] grid = new int[N][M];
        for(int i=0; i<N; i++) {
            grid[i] = Arrays.copyOf(originalGrid[i], M);
        }

        int killCount = 0;
        int enemies = countEnemies(grid);

        while(enemies > 0) {
            // 중복을 방지하기 위한 Point 객체를 저장할 Set
            Set<Point> targets = new HashSet<>();

            // 각 궁수에 대해 타겟 찾기
            for(int archer : selectedArchers) {
                Point target = findTarget(grid, archer);
                if(target != null) {
                    targets.add(target);
                }
            }

            // 타겟 제거 및 killCount 증가
            for(Point p : targets) {
                if(grid[p.r][p.c] == 1) {
                    killCount++;
                    grid[p.r][p.c] = 0;
                    enemies--;
                }
            }

            // 적 이동
            enemies = moveEnemies(grid);
        }

        // 최대 killCount 갱신
        if(killCount > maxKills) {
            maxKills = killCount;
        }
    }

    // 현재 그리드에서 적의 수를 세는 함수
    static int countEnemies(int[][] grid) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    // BFS를 사용하여 궁수가 공격할 타겟을 찾는 함수
    static Point findTarget(int[][] grid, int archerCol) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        // 궁수의 위치는 (N, archerCol)
        queue.add(new int[]{N, archerCol, 0});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];

            if(dist > D) continue;

            // 탐색 순서: 왼쪽, 위, 오른쪽
            for(int i=0; i<3; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                int nd = dist + 1;

                if(nr < 0 || nc < 0 || nc >= M || nr >= N) continue;
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if(grid[nr][nc] == 1) {
                        return new Point(nr, nc);
                    }
                    if(nd < D) {
                        queue.add(new int[]{nr, nc, nd});
                    }
                }
            }
        }

        return null;
    }

    // 적을 아래로 이동시키는 함수
    static int moveEnemies(int[][] grid) {
        int remaining = 0;
        // 마지막 행 제외하고 모든 행을 한 칸씩 아래로 이동
        for(int r=N-1; r>=1; r--) {
            for(int c=0; c<M; c++) {
                grid[r][c] = grid[r-1][c];
            }
        }
        // 첫 번째 행은 0으로 초기화
        for(int c=0; c<M; c++) {
            grid[0][c] = 0;
        }

        // 남아 있는 적의 수 세기
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(grid[r][c] == 1) remaining++;
            }
        }
        return remaining;
    }
}
