import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, heightLimit;
	static int[] arr;
	static List<Integer> list;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		
	//	System.setIn(new FileInputStream("src/김두철/A074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			heightLimit = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			
			powerset(0, 0);
			
			Collections.sort(list);
			int answer = list.get(0)-heightLimit;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void powerset(int index, int sum) {
		if (index == N) {
			if (sum >= heightLimit) {
				list.add(sum);
			}
			return;
		}
		
	    // 현재 index의 원소를 포함하는 경우
	    powerset(index + 1, sum + arr[index]);
	    // 현재 index의 원소를 포함하지 않는 경우
	    powerset(index + 1, sum);
		
		
	}

}
