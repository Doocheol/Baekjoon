
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[][] bingo = new int[5][5];
		int[] order = new int[25];

		for (int row = 0; row < 5; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int column = 0; column < 5; column++) {
				bingo[row][column] = Integer.parseInt(st.nextToken());
			}
		}
		int index = 0;
		for (int row = 0; row < 5; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int column = 0; column < 5; column++) {
				order[index++] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		int[] rowCount = new int[5];
		int[] columnCount = new int[5];
		int cross = 0;
		int antiCross = 0;
		int bingoCount = 0;

		for (int i = 0; i < 25; i++) {

			int num = order[i];
			count++;

			for (int row = 0; row < 5; row++) {
				for (int column = 0; column < 5; column++) {
					if (bingo[row][column] == num) {
						rowCount[row]++;
						columnCount[column]++;
						if (row == column) {
							cross++;
						}
						if (row == 5 - 1 - column) {
							antiCross++;
						}
						break;
					}

				}
			}
			
			bingoCount = 0;

			// 빙고 개수 세기
			for (int j = 0; j < 5; j++) {
				if (rowCount[j] == 5)
					bingoCount++;
				if (columnCount[j] == 5)
					bingoCount++;
			}
			if (cross == 5)
				bingoCount++;
			if (antiCross == 5)
				bingoCount++;

			// 빙고가 3개 이상이면 결과 출력 후 종료
			if (bingoCount >= 3) {
				sb.append(count);
				break;
			}

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
