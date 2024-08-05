import java.io.*;
import java.util.*;

// 1방에 배정 최대 인원 K
// 같은 학년 -> 같은 방
// 같은 성별 -> 같은 방

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 참가 학생 수
		int N = Integer.parseInt(st.nextToken());

		// 한 방에 배정할 수 있는 최대 인원 수
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][2];

		for (int r = 0; r < N; r++) {
			String[] line = br.readLine().trim().split(" ");
			for (int c = 0; c < 2; c++) {
				map[r][c] = Integer.parseInt(line[c]);
			}
		}

		int[] count = new int[12];
		// 남/여, 1~6학년 총 12가지

		for (int r = 0; r < N; r++) {
			if (map[r][0] == 0) {
				count[map[r][1] - 1]++;
			} else if (map[r][0] == 1) {
				count[map[r][1] - 1 + 6]++;
			}
		}

		int sum = 0;
		for (int i = 0; i < count.length; i++) {

			if (count[i] % K == 0) {
				sum += count[i] / K;
			} else {
				sum += (count[i] + K - 1) / K;
			}

		}
		
		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
