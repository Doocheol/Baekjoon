
import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 아홉 난쟁이 키 받기
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		
		// 일반조합 메서드
		find(0, 0, 0);
		
		
		// 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	// 아홉 난쟁이
	static int[] arr = new int[9];
	
	// 일곱 난쟁이 찾기
	static int[] answer = new int[7];
	static StringBuilder sb = new StringBuilder();
	static boolean found = false;
	
	// 일반조합
	public static void find(int depth, int start, int sum) {
		
		if (found) return;
		if (depth == answer.length) {
			if (sum == 100) {
				// 정렬
				Arrays.sort(answer);

				for (int i = 0; i < answer.length; i++) {
					sb.append(answer[i]).append("\n");
				}
				found = true;
			}
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
				answer[depth] = arr[i];
				find(depth + 1, i + 1, sum + arr[i]);
		}

	} // END method
		
}
