import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][] board;
	static boolean[][] isVisited;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for (int row = 0; row < N; row++) {
			char[] line = br.readLine().toCharArray();
			for (int column = 0; column < N; column++) {
				board[row][column] = line[column] - '0';
			}
		}
		
		isVisited = new boolean[N][N];
		list = new ArrayList<>();
		
		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {
				if (!isVisited[row][column] && board[row][column] == 1) {
					bfs(row, column);
				}
			}
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void bfs(int row, int column) {
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {row, column});
		isVisited[row][column] = true;
		int count = 1;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = currentX + dx[d];
				int ny = currentY + dy[d];
				
				if (check(nx, ny) && !isVisited[nx][ny] && board[nx][ny] == 1) {
					count++;
					queue.offer(new int[] {nx, ny});
					isVisited[nx][ny] = true;
				}
			}
		}
		
		list.add(count);
		
		
	}

	private static boolean check(int x, int y) {
		if (0<=x && x<N && 0<=y && y<N) return true;
		return false;
	}

}
