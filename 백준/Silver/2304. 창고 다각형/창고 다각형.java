
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] building = new int[N][2];
		
		for (int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			building[row][0] = Integer.parseInt(st.nextToken());  // x 좌표
			building[row][1] = Integer.parseInt(st.nextToken());  // 높이
		}
		
		// x 좌표 기준으로 오름차순 정렬
		Arrays.sort(building, Comparator.comparingInt(o -> o[0]));
		
		// 최대 높이 찾기
		int maxIdx = 0;
		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			if (building[i][1] > maxHeight) {
				maxHeight = building[i][1];
				maxIdx = i;
			}
		}
		
		// 좌측에서 최대 높이까지 면적 구하기
		int area = 0;
		int leftHeight = building[0][1];
		for (int i = 1; i <= maxIdx; i++) {
			if (building[i][1] > leftHeight) {
				area += leftHeight * (building[i][0] - building[i-1][0]);
				leftHeight = building[i][1];
			} else {
				area += leftHeight * (building[i][0] - building[i-1][0]);
			}
		}
		
		// 우측에서 최대 높이까지 면적 구하기
		int rightHeight = building[N-1][1];
		for (int i = N-2; i >= maxIdx; i--) {
			if (building[i][1] > rightHeight) {
				area += rightHeight * (building[i+1][0] - building[i][0]);
				rightHeight = building[i][1];
			} else {
				area += rightHeight * (building[i+1][0] - building[i][0]);
			}
		}
		
		// 최대 높이 부분 더하기
		area += maxHeight;
		
		// 최종 면적 출력
		sb.append(area);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
