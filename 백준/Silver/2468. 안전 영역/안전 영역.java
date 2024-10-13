import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	
	static int N;
	static int[][] heightInfos;
	static boolean[][] isVisited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		heightInfos = new int[N][N];
		
		
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int column = 0; column < N; column++) {
				heightInfos[row][column] = Integer.parseInt(st.nextToken());
				
				if (heightInfos[row][column] > maxHeight) maxHeight = Math.max(maxHeight, heightInfos[row][column]);
				if (heightInfos[row][column] < minHeight) minHeight = Math.min(minHeight, heightInfos[row][column]);
			}
		}
		
		
		int answer = 1; // 잠길 것이 아무것도 없으면 안전 영역은 1
		for (int currentHeight = minHeight; currentHeight <= maxHeight; currentHeight++) {
			
			int count = 0;
			isVisited = new boolean[N][N];
			
			for (int row = 0; row < N; row++) {
				for (int column = 0; column < N; column++) {
					if (!isVisited[row][column] && heightInfos[row][column] > currentHeight) {
						bfs(row, column, currentHeight);
						count++;
					}
					
				}
			}
			
			answer = Math.max(answer, count);
			
		}
		
		System.out.println(answer);
	
		
	}

	private static void bfs(int row, int column, int currentHeight) {

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] {row, column});
		isVisited[row][column] = true;
		
		
		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = currentX + dx[d];
				int ny = currentY + dy[d];
				
				if (check(nx, ny) && !isVisited[nx][ny] && heightInfos[nx][ny] > currentHeight) {
					queue.offer(new int[] {nx, ny});
					isVisited[nx][ny] = true;
				}
			}
			
		}
	}

	private static boolean check(int x, int y) {
		if (0<=x && x<N && 0<=y && y<N) return true;
		return false;
	}

}
