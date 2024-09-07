import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws Exception {
		
	//	System.setIn(new FileInputStream("A018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc<=10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[100][100];
			for (int row = 0; row < 100; row++) {
				String line = br.readLine();
				for (int column = 0; column < 100; column++) {
					board[row] = line.toCharArray();
				}
			}
			
			int maxLength = 1;
			
			//행 탐색
			for (int row = 0; row < 100; row++) {
				for (int start = 0; start < 100; start++) {
					for (int end = 99; end > start; end--) {
						if (checkRow(board, start, end, row)) {
							maxLength = Math.max(maxLength, end - start + 1);
						}
					}
					
				}
			}
			
			for (int column = 0; column < 100; column++) {
				for (int start = 0; start < 100; start++) {
					for (int end = 99; end > start; end--) {
						if (checkColumn(board, start, end, column)) {
							maxLength = Math.max(maxLength, end - start + 1);
						}
					}
				}
			}
			sb.append("#").append(N).append(" ").append(maxLength).append("\n");
		} // End tc
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	} // End main

	private static boolean checkRow(char[][] arr, int start, int end, int row) {

		while (start < end) {
			
			if (arr[row][start] != arr[row][end]) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
	
	private static boolean checkColumn(char[][] arr, int start, int end, int column) {

		while (start < end) {
			
			if (arr[start][column] != arr[end][column]) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
	
} // End class
