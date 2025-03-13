import java.util.*;
import java.io.*;

public class Main {
    
    private static int t, n, k;
    private static int[][] dp;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[15][15];
        for (int i = 0; i < 15; i++) {
            dp[i][1] = 1;
            dp[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
        
    }
}