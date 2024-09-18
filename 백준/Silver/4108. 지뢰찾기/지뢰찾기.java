import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if (N == 0 && M == 0) break;
			
			char[][] board = new char[N][M];
			char[][] newBoard = new char[N][M];
			
			for (int row = 0; row < N; row++) {
				String[] line = br.readLine().split("");
				for (int column = 0; column < M; column++) {
					board[row][column] = line[column].charAt(0);
					newBoard[row][column] = line[column].charAt(0);
				}
			}
			
			for (int row = 0; row < N; row++) {
				for (int column = 0; column < M; column++) {
					char ch = board[row][column];
					
					if (ch == '*') continue;
					
					
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int nr = row + dr[d];
						int nc = column + dc[d];
						
						if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
						
						if (board[nr][nc] == '*') count++;
					}
					
					newBoard[row][column] = (char) (count + '0');
					
				}
			}
			
			for (int row = 0; row < N; row++) {
				for (int column = 0; column < M; column++) {
					sb.append(newBoard[row][column]);
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
		
	}

}
