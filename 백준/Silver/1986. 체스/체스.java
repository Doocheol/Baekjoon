import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] Q = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1},
			{-1, -1}, {-1, 1}, {1, -1}, {1, 1}
	};
	static int[][] K = {
			{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
			{1, -2}, {2, -1}, {1, 2}, {2, 1}
	};
	static int[][] board;
	static boolean[][] canVisit;
	
	static class Position {
		int x;
		int y;
		int type; // 1, 2, 3
		
		public Position(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		canVisit = new boolean[N][M];
		Deque<Position> chessInfo = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		int numQ = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numQ; i++) {
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			board[row][col] = 1;
			canVisit[row][col] = true;
			chessInfo.offer(new Position(row, col, 1));
		}
		
		st = new StringTokenizer(br.readLine());
		int numK = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numK; i++) {
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			board[row][col] = 2;
			canVisit[row][col] = true;
			chessInfo.offer(new Position(row, col, 2));
		}
		
		st = new StringTokenizer(br.readLine());
		int numP = Integer.parseInt(st.nextToken());
		for (int i = 0; i < numP; i++) {
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			board[row][col] = 3;
			canVisit[row][col] = true;
		}
		
		
		while(!chessInfo.isEmpty()) {
			Position pos = chessInfo.poll();
			int x = pos.x;
			int y = pos.y;
			int type = pos.type;

			if (type == 1) {
				
				
				for (int d = 0; d < 8; d++) {
					for (int step = 1; step <= Math.max(N, M); step++) {
						int nx = x + Q[d][0] * step;
						int ny = y + Q[d][1] * step;
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != 0) break;
						
						canVisit[nx][ny] = true;
					}
				}
				
				
			} else if (type == 2) {
				
				for (int d = 0; d < 8; d++) {
					int nx = x + K[d][0];
					int ny = y + K[d][1];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					canVisit[nx][ny] = true;

				}
				
				
			}
		}
		
		
		int count = 0;
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < M; column++) {
				if (canVisit[row][column] == false) count++;
			}
		}
		
		System.out.println(count);
	}

}
