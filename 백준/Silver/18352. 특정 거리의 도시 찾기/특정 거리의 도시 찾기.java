import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N; // 도시의 개수
    static int M; // 도로의 개수
    static int K; // 거리 정보
    static int X; // 출발 도시의 번호
    static List<Integer>[] adjList; // 인접 리스트 배열 : 도로 연결 정보
    static int[] distance;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);
        bfs(X);

        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (!found) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adjList[current]) {
                if (distance[neighbor] == -1) { // 아직 방문하지 않은 경우
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
