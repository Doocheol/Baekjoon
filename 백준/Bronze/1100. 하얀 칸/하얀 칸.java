import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] board = new int[8][8];
		int count = 0;
		for (int row = 0; row < 8; row++) {
			String[] line = br.readLine().split("");
			for (int column = 0; column < 8; column++) {
				board[row][column] = line[column].charAt(0);
				
				if (row % 2 == 0) {
					if (column % 2 == 0) {
						if (board[row][column] == 'F') count++;
					}
				} else {
					if (column % 2 == 1) {
						if (board[row][column] == 'F') count++;
					}
				}
			}
		}
		
		System.out.println(count);
		
		
	}

}
