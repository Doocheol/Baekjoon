
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] ascending = new int[N];
		int[] descending = new int[N];
		ascending[0] = 1;
		descending[0] = 1;

		int index_A = 0;
		int key_A = arr[0];

		// 오름차순 확인
		for (int i = 1; i < N; i++) {
			if (key_A <= arr[i]) {
				key_A = arr[i];
				ascending[index_A]++;
			} else {
				key_A = arr[i];
				ascending[++index_A] = 1;
			}

		}

		int index_D = 0;
		int key_D = arr[0];
		
		// 내림차순 확인
		for (int i = 1; i < N; i++) {
			if (key_D >= arr[i]) {
				key_D = arr[i];
				descending[index_D]++;
			} else {
				key_D = arr[i];
				descending[++index_D] = 1;
			}
		}

		Arrays.sort(ascending);
		Arrays.sort(descending);

		int max = 1;
		max = Math.max(ascending[ascending.length - 1], descending[descending.length - 1]);

		sb.append(max);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
