
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		int[][] sum = new int[n][m];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				a[r][c] = sc.nextInt();
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				b[r][c] = sc.nextInt();
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				sum[r][c] = a[r][c] + b[r][c];
			}
		}
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				System.out.print(sum[r][c] + " ");
			}
			System.out.println();
		}
		
	}

}
