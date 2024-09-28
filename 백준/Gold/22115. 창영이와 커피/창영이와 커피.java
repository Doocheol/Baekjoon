import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄 입력: N과 K
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);
        
        // 두 번째 줄 입력: N개의 Ci
        String[] secondLine = br.readLine().split(" ");
        int[] C = new int[N];
        for(int i=0; i<N; i++) {
            C[i] = Integer.parseInt(secondLine[i]);
        }
        
        // DP 배열 초기화
        // dp[s] = 최소 커피 개수으로 합이 s인 경우
        // 초기에는 모든 dp[s]를 INF로 설정, 단 dp[0] = 0
        int INF = N + 1; // 최대 커피 개수는 N, INF는 그보다 큰 값
        int[] dp = new int[K + 1];
        for(int s=0; s<=K; s++) {
            dp[s] = INF;
        }
        dp[0] = 0;
        
        // 각 커피에 대해 DP 갱신
        for(int i=0; i<N; i++) {
            int ci = C[i];
            // s를 K부터 ci까지 감소시키면서 업데이트
            for(int s=K; s>=ci; s--) {
                if(dp[s - ci] + 1 < dp[s]) {
                    dp[s] = dp[s - ci] + 1;
                }
            }
        }
        
        // 결과 출력
        if(K == 0) {
            System.out.println(0);
        }
        else if(dp[K] <= N) {
            System.out.println(dp[K]);
        }
        else {
            System.out.println(-1);
        }
    }
}
