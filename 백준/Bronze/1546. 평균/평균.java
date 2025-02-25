import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 과목의 개수
		
		int[] scores = new int[N];
		
		String[] line = br.readLine().split(" ");
		int M = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(line[i]);
			M = Math.max(M, scores[i]);
		}
		
		float sum = 0;
		for (int i = 0; i < N; i++) {
			// 정수 나눗셈을 방지하기 위해 M을 float으로 변환
			sum += (float) scores[i] / M * 100;
		}
		
		float average = sum / N;
		
		System.out.println(average);
	}
}
