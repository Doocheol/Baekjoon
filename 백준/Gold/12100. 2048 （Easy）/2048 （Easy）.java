import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }
        
        // DFS 시작
        dfs(board, 0);
        
        // 결과 출력
        System.out.println(max);
    }
    
    // 백트래킹 함수
    static void dfs(int[][] currentBoard, int depth) {
        if(depth == 5) {
            // 5번 이동 후 최대 값 갱신
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(currentBoard[i][j] > max) {
                        max = currentBoard[i][j];
                    }
                }
            }
            return;
        }
        
        // 네 방향으로 이동 시도
        for(int dir=0; dir<4; dir++) {
            int[][] movedBoard = move(currentBoard, dir);
            
            // 이동 후 보드가 변하지 않았다면 탐색 중단
            if(Arrays.deepEquals(currentBoard, movedBoard)) {
                continue;
            }
            
            // 재귀 호출
            dfs(movedBoard, depth + 1);
        }
    }
    
    // 이동 함수
    static int[][] move(int[][] currentBoard, int direction) {
        int[][] newBoard = copyBoard(currentBoard);
        
        switch(direction) {
            case 0: // 위
                for(int j=0; j<N; j++) {
                    // 각 열마다 위로 이동
                    Queue<Integer> queue = new LinkedList<>();
                    for(int i=0; i<N; i++) {
                        if(newBoard[i][j] != 0) {
                            queue.add(newBoard[i][j]);
                            newBoard[i][j] = 0;
                        }
                    }
                    int position = 0;
                    while(!queue.isEmpty()) {
                        int current = queue.poll();
                        if(!queue.isEmpty() && current == queue.peek()) {
                            newBoard[position][j] = current * 2;
                            queue.poll(); // 합쳐진 타일은 제거
                        }
                        else {
                            newBoard[position][j] = current;
                        }
                        position++;
                    }
                }
                break;
            case 1: // 아래
                for(int j=0; j<N; j++) {
                    // 각 열마다 아래로 이동
                    Queue<Integer> queue = new LinkedList<>();
                    for(int i=N-1; i>=0; i--) {
                        if(newBoard[i][j] != 0) {
                            queue.add(newBoard[i][j]);
                            newBoard[i][j] = 0;
                        }
                    }
                    int position = N - 1;
                    while(!queue.isEmpty()) {
                        int current = queue.poll();
                        if(!queue.isEmpty() && current == queue.peek()) {
                            newBoard[position][j] = current * 2;
                            queue.poll(); // 합쳐진 타일은 제거
                        }
                        else {
                            newBoard[position][j] = current;
                        }
                        position--;
                    }
                }
                break;
            case 2: // 왼쪽
                for(int i=0; i<N; i++) {
                    // 각 행마다 왼쪽으로 이동
                    Queue<Integer> queue = new LinkedList<>();
                    for(int j=0; j<N; j++) {
                        if(newBoard[i][j] != 0) {
                            queue.add(newBoard[i][j]);
                            newBoard[i][j] = 0;
                        }
                    }
                    int position = 0;
                    while(!queue.isEmpty()) {
                        int current = queue.poll();
                        if(!queue.isEmpty() && current == queue.peek()) {
                            newBoard[i][position] = current * 2;
                            queue.poll(); // 합쳐진 타일은 제거
                        }
                        else {
                            newBoard[i][position] = current;
                        }
                        position++;
                    }
                }
                break;
            case 3: // 오른쪽
                for(int i=0; i<N; i++) {
                    // 각 행마다 오른쪽으로 이동
                    Queue<Integer> queue = new LinkedList<>();
                    for(int j=N-1; j>=0; j--) {
                        if(newBoard[i][j] != 0) {
                            queue.add(newBoard[i][j]);
                            newBoard[i][j] = 0;
                        }
                    }
                    int position = N - 1;
                    while(!queue.isEmpty()) {
                        int current = queue.poll();
                        if(!queue.isEmpty() && current == queue.peek()) {
                            newBoard[i][position] = current * 2;
                            queue.poll(); // 합쳐진 타일은 제거
                        }
                        else {
                            newBoard[i][position] = current;
                        }
                        position--;
                    }
                }
                break;
        }
        
        // 현재 이동 후 보드에서 최대 값을 갱신
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(newBoard[i][j] > max) {
                    max = newBoard[i][j];
                }
            }
        }
        
        return newBoard;
    }
    
    // 보드 복사 함수
    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][N];
        for(int i=0; i<N; i++) {
            newBoard[i] = Arrays.copyOf(board[i], N);
        }
        return newBoard;
    }
}
