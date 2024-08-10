
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 색종이가 놓이는 전체 면적의 사이즈
		final int SIZE = 1001;
		
		// 색종이의 개수
		int N = Integer.parseInt(br.readLine().trim());
		int[][] board = new int[SIZE][SIZE];
		
		//색종이1, 색종이2, 색종이3... 받기
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			
			// 색종이1이 차지하는 면적 먼저 받고, 색종이2가 덮어쓰고
			for (int row = x; row < x + width; row++) {
				for (int column = y; column < y + height; column++) {
					board[row][column] = i;
				}
			}
		}
		
		// 색종이 총 면적 카운트 배열 만들기 : area
		int[] area = new int[N+1];
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				if (board[row][column] != 0) {
					area[board[row][column]]++;
				}
			}
		}
		
		// 데이터 출력
		for (int index = 1; index <= N; index++) {
			sb.append(area[index]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
