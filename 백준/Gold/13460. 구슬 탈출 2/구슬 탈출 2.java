import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static char[][] board;
    static Point red, blue;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][][] visited;

    static class Point {
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class State {
        Point red;
        Point blue;
        int depth;

        State(Point red, Point blue, int depth){
            this.red = red;
            this.blue = blue;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = line.charAt(j);
                if(board[i][j] == 'R') {
                    red = new Point(i, j);
                    board[i][j] = '.'; // 구슬을 이동시키기 위해 빈 칸으로 변경
                }
                if(board[i][j] == 'B') {
                    blue = new Point(i, j);
                    board[i][j] = '.'; // 구슬을 이동시키기 위해 빈 칸으로 변경
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs(){
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(red, blue, 0));
        visited[red.x][red.y][blue.x][blue.y] = true;

        while(!queue.isEmpty()){
            State current = queue.poll();

            // 이동 횟수가 10회를 초과하면 종료
            if(current.depth >= 10){
                continue;
            }

            for(int dir=0; dir<4; dir++){
                // 구슬 이동
                Point newRed = move(current.red.x, current.red.y, dir);
                Point newBlue = move(current.blue.x, current.blue.y, dir);

                // 파란 구슬이 구멍에 빠지면 무시
                if(board[newBlue.x][newBlue.y] == 'O'){
                    continue;
                }

                // 빨간 구슬이 구멍에 빠졌다면 결과 반환
                if(board[newRed.x][newRed.y] == 'O'){
                    return current.depth + 1;
                }

                // 두 구슬이 같은 위치에 있을 경우 위치 조정
                if(newRed.x == newBlue.x && newRed.y == newBlue.y){
                    // 이동 방향에 따라 위치 조정
                    int redDist = Math.abs(newRed.x - current.red.x) + Math.abs(newRed.y - current.red.y);
                    int blueDist = Math.abs(newBlue.x - current.blue.x) + Math.abs(newBlue.y - current.blue.y);

                    if(redDist > blueDist){
                        newRed.x -= dx[dir];
                        newRed.y -= dy[dir];
                    }
                    else{
                        newBlue.x -= dx[dir];
                        newBlue.y -= dy[dir];
                    }
                }

                // 방문 여부 확인
                if(!visited[newRed.x][newRed.y][newBlue.x][newBlue.y]){
                    visited[newRed.x][newRed.y][newBlue.x][newBlue.y] = true;
                    queue.add(new State(newRed, newBlue, current.depth + 1));
                }
            }
        }

        // 10회 내에 탈출하지 못하면 -1 반환
        return -1;
    }

    // 특정 방향으로 구슬을 이동시키는 함수
    static Point move(int x, int y, int dir){
        int nx = x;
        int ny = y;

        while(true){
            // 다음 위치가 벽이면 멈춤
            if(board[nx + dx[dir]][ny + dy[dir]] == '#'){
                break;
            }

            nx += dx[dir];
            ny += dy[dir];

            // 구멍에 빠지면 멈춤
            if(board[nx][ny] == 'O'){
                break;
            }
        }

        return new Point(nx, ny);
    }
}
