import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	
	static boolean[][] isVisited;
	static int[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int startX, startY, endX, endY;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("미로1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			
			board=new int[16][16];
			isVisited=new boolean[16][16];
			
			startX = startY = 0;
			int T = Integer.parseInt(br.readLine());
			
			for (int row = 0; row < 16; row++) {
				char[] line = br.readLine().toCharArray();
				for (int column = 0; column < 16; column++) {
					board[row][column] = line[column] - '0';
					if (board[row][column] == 1) {
						isVisited[row][column] = true;
					} else if (board[row][column] == 2) {
						startX = row;
						startY = column;
					}
				}
			}
			
			answer = 0; // 초기값 0
			bfs(startX, startY);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int row, int column) {
		Deque<Integer> x = new ArrayDeque<>();
		Deque<Integer> y = new ArrayDeque<>();
		
		x.offer(row);
		y.offer(column);
		isVisited[row][column] = true;
		
		while(!x.isEmpty()) {
			int currentX = x.poll();
			int currentY = y.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = currentX + dr[d];
				int ny = currentY + dc[d];
				
				if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
				if (board[nx][ny] == 1 || isVisited[nx][ny] == true) continue;
				if (board[nx][ny] == 0 && !isVisited[nx][ny]) {
					x.offer(nx);
					y.offer(ny);
					isVisited[nx][ny] = true;
				}
				if (board[nx][ny] == 3) {
					answer = 1;
					return;
				}
			}
		}
		
		
	}

}
