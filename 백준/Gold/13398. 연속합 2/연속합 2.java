import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] leftArr = new int[N];
        leftArr[0] = arr[0];
        int result = leftArr[0];
        
        for (int i = 1; i < N; i++) {
            leftArr[i] = Math.max(arr[i], leftArr[i-1] + arr[i]);
            result = Math.max(result, leftArr[i]);
        }
        
        int[] rightArr = new int[N];
        rightArr[N-1] = arr[N-1];
        for (int i = N-2; i >= 0; i--) {
            rightArr[i] = Math.max(arr[i], rightArr[i+1] + arr[i]);
        }
        
        for (int i = 1; i < N - 1; i++) {
            int temp = leftArr[i-1] + rightArr[i+1];
            result = Math.max(result, temp);
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
}