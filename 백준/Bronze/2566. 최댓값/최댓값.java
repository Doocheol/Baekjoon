import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = 9;
		int[][] map = new int[N][N];
		
		for (int r = 0; r < map.length; r++) {
			String[] str = br.readLine().split(" ");
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = Integer.parseInt(str[c]);
			}
		}
		
		int max = 0;
		int i = 0;
		int j = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(max == map[r][c]) {
					i = r + 1;
					j = c + 1;
				}
			}
		}
		
		
		sb.append(max).append("\n");
		sb.append(i).append(" ").append(j);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
