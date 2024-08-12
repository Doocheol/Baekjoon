
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
	//	System.setIn(new FileInputStream("src/김두철/A036.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// A회사
			int P = Integer.parseInt(st.nextToken());
			
			// B회
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			int W = Integer.parseInt(st.nextToken());
			
			int A = P * W;
			int B = 0;
			
			if (R >= W) {
				B = Q;
			} else {
				B = Q + (W-R) * S;
			}
			
			sb.append("#").append(tc).append(" ");
			if (A < B) {
				sb.append(A);
			} else if (A > B) {
				sb.append(B);
			}
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
