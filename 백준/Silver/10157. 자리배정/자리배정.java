
import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int TARGET = Integer.parseInt(br.readLine());
		int TARGET_x = 0;
		int TARGET_y = 0;
		
		// N * M 배열 사이즈 받기
		
		int[][] board = new int[N][M];
		
		int num = 1;
		int x = 0;
		int y = 0;
		int dir = 0;
		
		// 공연장 좌표를 먼저 시계방향으로 돌려서 눕혀야 함.
		// 우, 하, 좌 ,상
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for (int i = 0; i < N * M; i++) {
			
			if (TARGET == num) {
				TARGET = num;
				TARGET_x = x + 1;
				TARGET_y = y + 1;
			}
			
			board[x][y] = num++;
			
			int nr = x + dr[dir];
			int nc = y + dc[dir];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != 0) {
				dir = (dir + 1) % 4;
			}
			
			x = x + dr[dir];
			y = y + dc[dir];
			
		}
		
		if (TARGET <= num) {
			sb.append(TARGET_x).append(" ").append(TARGET_y);
		} else {
			sb.append(0);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
