import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static StringBuilder sb;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int currentNumber, int currentDigit) {
		if (currentDigit == N) {
			if (primeNumber(currentNumber))
				sb.append(currentNumber).append("\n");
			
			return;
		}
			
		
		
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 0) continue;
			if (primeNumber(currentNumber * 10 + i)) {
				dfs(currentNumber * 10 + i, currentDigit + 1);
				
			}
			
		}
		
		
		
	}

	private static boolean primeNumber(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) return false;
		}
		
		return true;
	}

}
