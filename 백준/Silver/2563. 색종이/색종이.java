
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		final int SIZE = 101;
		
		
		// 중복 체크를 위한 boolean 배열 선언
		boolean[][] board = new boolean[SIZE][SIZE];
		int N = Integer.parseInt(br.readLine().trim());
		
		// 색종이 갯수만큼 계산하기
		for (int index = 1; index <= N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			// 색종이의 크기 10 x 10
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					board[i][j] = true;
				}
			}

		}
		
		// 해당 인덱스에 true 표시가 되었다면 sum++
		int sum = 0;
		int[] area = new int[N + 1];
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (board[row][column])
					sum++;
			}
		}

		sb.append(sum);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
