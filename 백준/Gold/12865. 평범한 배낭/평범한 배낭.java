import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 처리하기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 줄에서 N과 K를 입력받음
        int N = Integer.parseInt(st.nextToken()); // 물건의 수
        int K = Integer.parseInt(st.nextToken()); // 배낭의 최대 무게

        // 각 물건의 무게와 가치를 저장할 배열
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        // 물건 정보 입력받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken()); // 물건의 무게
            values[i] = Integer.parseInt(st.nextToken());  // 물건의 가치
        }

        // DP 배열 초기화: 배낭의 무게가 0부터 K까지일 때의 최대 가치
        int[] dp = new int[K + 1];

        // 각 물건을 순서대로 고려
        for (int i = 1; i <= N; i++) {
            // 배낭의 무게를 큰 값부터 작은 값으로 반복하여 0-1 배낭 문제를 해결
            for (int j = K; j >= weights[i]; j--) {
                // 현재 무게 j에서, 물건 i를 담을 경우의 가치 계산
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 배낭의 최대 무게 K일 때의 최대 가치를 출력
        System.out.println(dp[K]);
    }
}
