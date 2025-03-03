import java.util.*;
import java.io.*;

public class Main {
   private static long mod = 1_000_000_000;
    
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       long[][] dp = new long[N+1][11];
       for (int i = 1; i <= 9; i++) {
           dp[1][i] = 1;
       }
       for (int i = 2; i <= N; i++) {
           dp[i][0] = dp[i-1][1];
           dp[i][9] = dp[i-1][8];
           for (int j = 1; j <= 8; j++) {
               dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
           }
       }
       long sum = 0;
       for (int i = 0; i < 10; i++) {
           sum = (sum + dp[N][i]) % mod;
       }
       System.out.println(sum);
       
   }
}