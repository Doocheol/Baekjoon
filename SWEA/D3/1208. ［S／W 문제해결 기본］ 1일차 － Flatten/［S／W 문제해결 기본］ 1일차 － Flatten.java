
import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] arr, temp;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A준비/P004_SWEA1208_Flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc<=10; tc++) {
			
			int dump = Integer.parseInt(br.readLine().trim());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 배열 크기
			int N = st.countTokens();
			
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			temp = new int[N];
			
			mergeSort(0, N-1);

			while ((arr[0] != arr[N-1]) && dump != 0) {
				dump--;
				arr[0]++;
				arr[N-1]--;
				mergeSort(0, N-1);
			}
			
			int min = Math.abs(arr[0] - arr[N-1]);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void mergeSort(int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}

		
	}
}
