import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int daily, monthly, quarterly, yearly;
	static int minCost;
	static int[] count;
	static final int N = 12;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("A064.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc<=T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			daily = Integer.parseInt(st.nextToken());
			monthly = Integer.parseInt(st.nextToken());
			quarterly = Integer.parseInt(st.nextToken());
			yearly = Integer.parseInt(st.nextToken());
			
			count = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}
			
			minCost = yearly;
		
			dfs(1, 0);
			
			sb.append("#").append(tc).append(" ").append(minCost).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void dfs(int month, int currentCost) {

		if (currentCost >= minCost) return;
		
		if (month > N) {
			if (currentCost < minCost) {
				minCost = currentCost;
			}
			return;
		}
		
		if (count[month] == 0) {
			dfs(month + 1, currentCost);
		} else {
			dfs(month + 1, currentCost + daily * count[month]);
			dfs(month + 1, currentCost + monthly);
			dfs(month + 3, currentCost + quarterly);
		}
		
		
	}

}
