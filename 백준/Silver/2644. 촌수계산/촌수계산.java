import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, start, target, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		isVisited = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		int answer = bfs(start);
		
		
		System.out.println(answer);
		
	}

	private static int bfs(int currentNode) {

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(currentNode);
		isVisited[currentNode] = true;
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				
				if (current == target) return count;
				
				for (int next : adjList[current]) {
					
					if (!isVisited[next]) {
						queue.offer(next);
						isVisited[next] = true;
					}
				}
				
			}
			
			count++;

			
			
		}
		
		return -1;
	}

}
