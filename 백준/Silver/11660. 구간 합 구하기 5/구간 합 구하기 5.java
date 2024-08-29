import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //배열의 크기
		int M = Integer.parseInt(st.nextToken()); // 합 구해야 하는 횟수
		
		int[][] board = new int[N][N];
		int[][] prefixSum = new int[N+1][N+1];
		
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int column = 0; column < N; column++) {
				board[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int row = 1; row < N+1; row++) {
			for (int column = 1; column < N+1; column++) {
				
				prefixSum[row][column] = 
						board[row-1][column-1] +
						prefixSum[row - 1][column] +
						prefixSum[row][column - 1] -
						prefixSum[row-1][column-1];
				
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
			
			int answer =
					prefixSum[x2][y2] -
					prefixSum[x1 - 1][y2] -
					prefixSum[x2][y1 - 1] +
					prefixSum[x1 - 1][y1 - 1];
			
			sb.append(answer).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
