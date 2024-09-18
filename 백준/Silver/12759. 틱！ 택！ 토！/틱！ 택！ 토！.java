import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int answer = 0;

		int[] rowCount1 = new int[3];
		int[] columnCount1 = new int[3];
		int cross1 = 0;
		int antiCross1 = 0;
		int[] rowCount2 = new int[3];
		int[] columnCount2 = new int[3];
		int cross2 = 0;
		int antiCross2 = 0;

		// 선플레이어 입력
		int currentPlayer = Integer.parseInt(br.readLine());
		int count = 1;
		
		while (count <= 9) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int column = Integer.parseInt(st.nextToken()) - 1;
			
			if (currentPlayer == 1) {
				rowCount1[row]++;
				columnCount1[column]++;
				if (row == column) cross1++;
				if (row + column == 2) antiCross1++;
				
				
				if (rowCount1[row] == 3 || columnCount1[column] == 3 
						|| cross1 == 3 || antiCross1 == 3) {
					answer = 1;
					break;
				}
					
				
				currentPlayer = 3 - currentPlayer;
				count++;
			} else {
				rowCount2[row]++;
				columnCount2[column]++;
				if (row == column) cross2++;
				if (row + column == 2) antiCross2++;
				
				
				if (rowCount2[row] == 3 || columnCount2[column] == 3 
						|| cross2 == 3 || antiCross2 == 3) {
					answer = 2;
					break;
				}
				
				currentPlayer = 3 - currentPlayer;
				count++;
			}
		}
		
		System.out.println(answer);
	}

}
