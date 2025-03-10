import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[][] dp = new long[1001][1001];
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long max = 0;
        
        for (int i = 0; i < n; i++) {
            String mline = br.readLine();
            for (int j = 0; j < m; j++) {
                dp[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
                if (dp[i][j] == 1 && j > 0 && i > 0) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + dp[i][j];
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max * max);
        
    }
    
}