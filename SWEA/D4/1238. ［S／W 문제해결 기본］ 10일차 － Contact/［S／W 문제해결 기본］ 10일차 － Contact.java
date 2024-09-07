import java.io.*;
import java.util.*;

/*
 * 아이디어
 * - BFS 활용!
 * - 인접리스트 배열
 * - 방문 배열
 */
public class Solution {

    static ArrayList<Integer>[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {

  //      System.setIn(new FileInputStream("src/김두철/A070.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            String[] line = br.readLine().split(" ");
            int numEdges = Integer.parseInt(line[0]); // 총 연락망의 길이
            int start = Integer.parseInt(line[1]); // 시작 노드

            String[] line2 = br.readLine().split(" ");

            // 최대 노드를 찾아서 그에 맞는 배열 크기를 설정
            int maxNode = 0;
            for (int i = 0; i < line2.length; i += 2) {
                maxNode = Math.max(maxNode, Integer.parseInt(line2[i]));
                maxNode = Math.max(maxNode, Integer.parseInt(line2[i + 1]));
            }

            // 연락망을 생성하기 위해 최대 노드 크기에 맞춘 리스트 배열 생성
            list = new ArrayList[maxNode + 1];
            isVisited = new boolean[maxNode + 1]; // 방문 여부 체크 배열

            for (int i = 0; i <= maxNode; i++) {
                list[i] = new ArrayList<>();
            }

            // 인접 리스트 생성
            for (int i = 0; i < line2.length; i += 2) {
                int from = Integer.parseInt(line2[i]);
                int to = Integer.parseInt(line2[i + 1]);
                list[from].add(to);
            }

            // BFS 탐색 수행
            int result = bfs(start);

            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        isVisited[start] = true;

        int maxNode = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxNode = 0;

            // 같은 레벨의 노드를 전부 탐색
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                maxNode = Math.max(maxNode, current); // 가장 번호가 큰 노드로 업데이트

                for (int next : list[current]) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        return maxNode; // 가장 마지막에 연락받는 번호가 큰 사람
    }
}
