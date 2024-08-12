
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A038.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] pascal = new int[N][];
			for (int i = 0; i < N; i++) {
				pascal[i] = new int[i + 1];
				pascal[i][0] = 1;
				pascal[i][i] = 1;
				
				for (int j = 1; j < i; j++) {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
			
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < pascal.length; i++) {
				for (int j = 0; j < pascal[i].length; j++) {
					sb.append(pascal[i][j] + " ");
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
