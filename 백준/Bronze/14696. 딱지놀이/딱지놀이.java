
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		// 접근 방법 : 카운트 배열 만들기
		for (int round = 1; round <= N; round++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A_length = Integer.parseInt(st.nextToken());
			
			int[] A = new int[5]; // 별4, 동그라미3, 네모2, 세모1
			for (int i = 0; i < A_length; i++) {
				int num = Integer.parseInt(st.nextToken());
				A[num]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int[] B = new int[5];
			int B_length = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < B_length; i++) {
				int num = Integer.parseInt(st.nextToken());
				B[num]++;
			}
			
			
			// 카운트 배열끼리 비교, 별 우선순위부터 탐색해야 됨. 
			boolean draw = false;
			for (int i = 4; i >= 1; i--) {
				if (A[i] > B[i]) {
					sb.append("A").append("\n");
					draw = true;
					break;
				} else if (A[i] < B[i]) {
					sb.append("B").append("\n");
					draw = true;
					break;
				}

			}
			if (!draw) {
				sb.append("D").append("\n");
			}
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
