
import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc<=10; tc++) {
			int N = 100;
			int[][] board = new int[N][N];
			boolean[][] isVisited = new boolean[N][N];
			
			int x = 99;
			int y = -1;
			
			int number = Integer.parseInt(br.readLine().trim());
			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int column = 0; column < N; column++) {
					board[row][column] = Integer.parseInt(st.nextToken());
					if (board[row][column] == 2) y = column;
				}
			}
			
			while (x >= 0) {
				isVisited[x][y] = true;
				int left = y - 1;
				int right = y + 1;
				
				if (left >= 0 && board[x][left] == 1 &&!isVisited[x][left])
					y--;
				else if(right < N && board[x][right] == 1 && !isVisited[x][right])
					y++;
				else
					x--;
			}
			sb.append("#").append(tc).append(" ").append(y).append("\n");
			
		} // End testcase
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	} // End main
	
} // End class
