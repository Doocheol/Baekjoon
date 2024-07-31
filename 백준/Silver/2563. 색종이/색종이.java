import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int n = Integer.parseInt(br.readLine().trim());
		
		boolean[][] check = new boolean[100][100];
		
		int x = 0; // x좌표
		int y = 0; // y좌표 
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			x = Integer.parseInt(str[0]);
			y = Integer.parseInt(str[1]);
			
			
			for (int r = x; r < x + 10; r++) {
				for (int c = y; c < y + 10; c++) {
					check[r][c] = true;
				}
			}

		}
		int Ans = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (check[r][c]) {
					Ans++;
				}
			}
		}
		sb.append(Ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
