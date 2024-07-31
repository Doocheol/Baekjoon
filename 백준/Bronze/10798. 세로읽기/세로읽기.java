import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		char[][] arr = new char[5][15];
		
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int c = 0; c < 15; c++) {
            for (int r = 0; r < 5; r++) {
                if (arr[r][c] != '\0') {
                    sb.append(arr[r][c]);
                }
            }
        }
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
