import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[][] isVisited;
	static int count;
	static int startRow, startCol, targetRow, targetCol;
	static int[] dx = {-2, -1, -2, -1, 2, 1, 2, 1};
	static int[] dy = {-1, -2, 1, 2, 1, 2, -1, -2};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			isVisited = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			startRow = Integer.parseInt(st.nextToken());
			startCol = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			targetRow = Integer.parseInt(st.nextToken());
			targetCol = Integer.parseInt(st.nextToken());
			
			count = 0;
			bfs(startRow, startCol);
			
			System.out.println(count);
			
		}
		
	}

	private static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {x, y});
		isVisited[x][y] = true;
		
		if (x == targetRow && y == targetCol) return;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			count++;
			
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				int currentX = current[0];
				int currentY = current[1];
				
				for (int d = 0; d < 8; d++) {
					int nx = currentX + dx[d];
					int ny = currentY + dy[d];
					
					if (check(nx, ny) && !isVisited[nx][ny]) {
						queue.offer(new int[] {nx, ny});
						isVisited[nx][ny] = true;
					}
					
					if (nx == targetRow && ny == targetCol) return;
				}
			
			}
			
			
			
		}
		
		
		
		return;
	}

	private static boolean check(int x, int y) {
		if (0<=x && x<N && 0<=y && y <N) return true;
		return false;
	}

}
