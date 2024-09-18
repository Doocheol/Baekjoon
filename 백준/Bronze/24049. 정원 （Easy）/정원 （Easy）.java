import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		for (int row = 1; row <= N; row++) {
			board[row][0] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int column = 1; column <= M; column++) {
			board[0][column] = Integer.parseInt(st.nextToken());
		}
		
		for (int row = 1; row <= N; row++) {
			for (int column = 1; column <= M; column++) {
				if (board[row-1][column] == board[row][column-1]) {
					board[row][column] = 0;
				} else {
					board[row][column] = 1;
				}
				
			}
		}
		
		System.out.println(board[N][M]);
		
	}

}
