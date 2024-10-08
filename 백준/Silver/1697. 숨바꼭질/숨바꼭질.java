import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    
    static int N, K, answer;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        answer = -1;
        isVisited = new boolean[100001];
        
        bfs(N);
        
        System.out.println(answer);
        
    }
    
    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start);
        isVisited[start] = true;
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 노드 수
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                // 목표 위치에 도달했을 경우
                if (current == K) {
                    answer = steps;
                    return;
                }
                
                // 가능한 모든 이동 방법을 시도
                int[] nextPositions = {current - 1, current + 1, current * 2};
                for (int next : nextPositions) {
                    if (next >= 0 && next <= 100000 && !isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
            
            steps++; // 한 레벨을 모두 처리한 후 단계 증가
        }
    }
}
