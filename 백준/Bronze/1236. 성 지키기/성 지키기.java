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
		char[][] board = new char[N][M];

		
		for (int row = 0; row < N; row++) {
			String[] line = br.readLine().split("");
			for (int column = 0; column < M; column++) {
				board[row][column] = line[column].charAt(0);
			}
		}
		
		int answerRow = 0;
		int answerColumn = 0;
		
		for (int row = 0; row < N; row++) {
			
			int rowCount = 0;
			
			for (int column = 0; column < M; column++) {
				if (board[row][column] == 'X') {
					break;
				} else {
					rowCount++;
				}
				
				if (rowCount == M) {
					answerRow++;
					break;
				}
			}
		}
		
		for (int column = 0; column < M; column++) {
			
			int columnCount = 0;

			for (int row = 0; row < N; row++) {
				if (board[row][column] == 'X') {
					break;
				} else {
					columnCount++;
				}
				
				if (columnCount == N) {
					answerColumn++;
				}
			}
		}
		
		int answer = Math.max(answerRow, answerColumn);
		System.out.println(answer);
		
	}

}
