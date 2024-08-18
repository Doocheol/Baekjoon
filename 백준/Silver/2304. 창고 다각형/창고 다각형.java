
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] heights = new int[1001];
		
		int max = Integer.MIN_VALUE;
		int maxIdx = Integer.MIN_VALUE;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int position = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			heights[position] = height;
			if (height > max) {
				max = height;
				maxIdx = position;
			}
		}
		
		int left = 0;
		for (int i = 0; i <= maxIdx; i++) {
			if (heights[i] > left) {
				left = heights[i];
			}
			sum += left;
		}
		
		int right = 0;
		for (int i = heights.length - 1; i > maxIdx; i--) {
			if (heights[i] > right) {
				right = heights[i];
			}
			sum += right;
		}
		
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
