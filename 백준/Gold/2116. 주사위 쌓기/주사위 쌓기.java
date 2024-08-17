
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] dice = new int[N][6];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 대칭구조 (마주보는 면 인덱스)
		
		//                0  1  2  3  4  5
		int[] opposite = {5, 3, 4, 1, 2, 0};
		
		int maxSum = 0;
		
		// 첫번째 주사위의 각 면을 바닥으로 놓는 경우를 시도
		for (int i = 0; i < 6; i++) {
			int sum = 0;
			int bottom = dice[0][i];
			int top = dice[0][opposite[i]];
			
			for (int j = 0; j < N; j++) {
				int maxSide = 0;
				
				// 현재 주사위의 옆면 최대값 계산 (천장과 바닥을 제외한 면들)
				for (int k = 0; k < 6; k++) {
					if (dice[j][k] != bottom && dice[j][k] != top) {
						maxSide = Math.max(maxSide, dice[j][k]);
					}
				}
				
				sum += maxSide;
				
				// 다음 주사위의 바닥과 천장 정하기
				if (j < N - 1) {
					for (int k = 0; k < 6; k++) {
						if (dice[j + 1][k] == top) {
							bottom = dice[j + 1][k];
							top = dice[j + 1][opposite[k]];
							break;
						}
					}
				}
			}
			
			// 최대값 갱신
			maxSum = Math.max(maxSum, sum);
		}
		
		sb.append(maxSum).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
