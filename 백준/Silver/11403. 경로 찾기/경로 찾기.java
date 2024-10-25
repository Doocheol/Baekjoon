import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] adjMatrix;
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int column = 0; column < N; column++) {
                adjMatrix[row][column] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-와샬 알고리즘
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (adjMatrix[i][k] == 1 && adjMatrix[k][j] == 1) {
                        adjMatrix[i][j] = 1;
                    }
                }
            }
        }

        // 출력 준비
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                sb.append(adjMatrix[row][column]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
