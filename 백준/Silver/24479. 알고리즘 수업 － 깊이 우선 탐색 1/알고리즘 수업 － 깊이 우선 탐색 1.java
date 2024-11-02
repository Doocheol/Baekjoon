import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> adjList;
    static int[] order;
    static boolean[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        R = Integer.parseInt(st.nextToken()); // 시작 노드

        // 인접 리스트 초기화
        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // 각 노드의 연결 리스트를 오름차순으로 정렬
        for(int i=1; i<=N; i++) {
            Collections.sort(adjList.get(i));
        }

        // 방문 여부 및 순서 기록 배열 초기화
        visited = new boolean[N+1];
        order = new int[N+1];

        // DFS 수행
        dfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    // DFS 재귀 함수
    public static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;
        
        for(int neighbor : adjList.get(node)) {
            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
