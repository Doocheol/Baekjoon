import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("A007.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(100);
		
		int N = Integer.parseInt(br.readLine().trim());
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > K) {
				K = arr[i];
			}
		}
		
		int[] count = new int[K+1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		int[] sortedArr = new int[arr.length];
		
		for (int i = 0; i < sortedArr.length; i++) {
			sortedArr[count[arr[i]] - 1] = arr[i];
		}
		
		int middle = sortedArr[(arr.length - 1)/2];
		sb.append(middle);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

		
	}
	
}
