import java.util.*;
import java.io.*;

public class Solution {
	
	static final int SIZE = 9;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("A030.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc<=T; tc++) {
			
			int[][] board = new int[SIZE][SIZE];
			
			for (int row = 0; row < SIZE; row++) {
				String[] line = br.readLine().split(" ");
				for (int column = 0; column < SIZE; column++) {
					board[row][column] = Integer.parseInt(line[column]);
				}
			}
			int answer = 0;
			
			if (check(SIZE, board)) {
				answer = 1;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean check(int N, int[][] board) {

		for (int r = 0; r < N; r++) {
			boolean[] isSelected = new boolean[10];
			for (int c = 0; c < N; c++) {
				int number = board[r][c];
				if (isSelected[number]) return false;
				isSelected[number] = true;
			}
		}
		
		for (int c = 0; c < N; c++) {
			boolean[] isSelected = new boolean[10];
			for (int r = 0; r < N; r++) {
				int number = board[r][c];
				if (isSelected[number]) return false;
				isSelected[number] = true;
			}
		}
		
		boolean[][][] isSelected = new boolean[3][3][10];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int i = r / 3;
				int j = c / 3;
				int number = board[r][c];
				
				if (isSelected[i][j][number]) return false;
				isSelected[i][j][number] = true;
			}
		}
		
		return true;
	
	}

}
