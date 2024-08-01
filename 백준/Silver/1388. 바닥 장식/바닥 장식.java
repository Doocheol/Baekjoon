
import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static char[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		String line = br.readLine().trim();
		
		StringTokenizer st = new StringTokenizer(line);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine().trim();
			for (int c = 0; c < M; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		int count = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (visited[r][c]) {
					continue;
				}
				if (arr[r][c] == '-') {
					dfs(r, c, true);
				} else {
					dfs(r, c, false);
				}
				count++;
			}
		}
		
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	} // END main
	
	static void dfs(int i, int j, boolean row) {
		visited[i][j] = true;
		if (row) {
			j++;
			if ( j < M && arr[i][j] == '-') {
				dfs(i, j, true);
			}
		} else {
			i++;
			if (i < N && arr[i][j] != '-') {
				dfs(i, j, false);
			}
		}
	} // END method

} // END class
