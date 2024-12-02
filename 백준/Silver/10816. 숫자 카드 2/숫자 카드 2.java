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

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(CountEndpoint(arr, target) - CountStartpoint(arr, target)).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	private static int CountEndpoint(int[] arr, int target) {

		int start = 0;
		int end = arr.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (arr[mid] > target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}
	
	private static int CountStartpoint(int[] arr, int target) {

		int start = 0;
		int end = arr.length;
		
		while (start < end) {
			int mid = (start + end) / 2;
			
			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return start;
	}

//		for (int i = 0; i < M; i++) {
//			int target = Integer.parseInt(st.nextToken());
//			
//			int firstIndex = Arrays.binarySearch(arr, target);
//			
//			if (firstIndex < 0) {
//				sb.append(0).append(" ");
//			} else {
//				int count = countCounter(arr, target, firstIndex);
//				sb.append(count).append(" ");
//			}
//			
//		}
//		System.out.println(sb);
//
//	}
//
//	private static int countCounter(int[] arr, int target, int firstIndex) {
//		int count = 1;
//		
//		for (int i = firstIndex - 1; i >= 0 && arr[i] == target; i--) count++;
//		for (int i = firstIndex + 1; i < arr.length && arr[i] == target; i++) count++;
//		
//		return count;
//	}

	

}
