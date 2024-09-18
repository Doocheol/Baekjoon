import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
		
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] prefixSum = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		long[] modCount = new long[M];
		long answer = 0;
		for (int i = 1; i <= N; i++) {
			int temp = (int) (prefixSum[i] % M);
			if (temp == 0) answer++;
			
			modCount[temp]++;
		}
		
		for (int i = 0; i < M; i++) {
			if (modCount[i] > 1) {
				answer = answer + (modCount[i] * (modCount[i] - 1) / 2);
			}
		}
		System.out.println(answer);
		
		
		
	}

}
