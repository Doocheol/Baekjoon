
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("src/김두철/A039.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		String[] grades = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Double[] scores = new Double[N];
			int targetIndex = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());

				scores[i] = 0.35 * mid + 0.45 * fin + 0.20 * homework;

				if (i == K - 1) {
					targetIndex = i;
				}
			}

			Double targetScore = scores[targetIndex];
			Arrays.sort(scores, Collections.reverseOrder());

			int rank = Arrays.asList(scores).indexOf(targetScore);
			int gradeIndex = (rank * 10) / N;

			sb.append("#").append(tc).append(" ").append(grades[gradeIndex]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
