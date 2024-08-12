
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("src/김두철/A040.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] board = new int[N][N];

			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int column = 0; column < N; column++) {
					board[row][column] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int row = 0; row < N; row++) {
				int word = 0;
				for (int column = 0; column < N; column++) {
					if (board[row][column] == 1) {
						word++;
					} else {
						if (word == K) {
							count++;
						}
						word = 0;
					}
				}
				if (word == K) { // 마지막 칸까지 검사
					count++;
				}
			}

			// 세로 방향 검사
			for (int column = 0; column < N; column++) {
				int word = 0;
				for (int row = 0; row < N; row++) {
					if (board[row][column] == 1) {
						word++;
					} else {
						if (word == K) {
							count++;
						}
						word = 0;
					}
				}
				if (word == K) { // 마지막 칸까지 검사
					count++;
				}
			}

			sb.append("#").append(tc).append(" ").append(count).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
