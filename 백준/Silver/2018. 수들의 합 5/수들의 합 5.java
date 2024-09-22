import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
		int start = 1;
		int end = 1;
		int answer = 1;
		
		while (end != N) {
			
			if (sum == N) {
				answer++;
				end++;
				sum += end;
			} else if (sum > N) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
			
		}
		
		System.out.println(answer);
		
	}

}
