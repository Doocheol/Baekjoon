import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, nodes;
	static ArrayList<Integer>[] adjList;
	static boolean[] computers;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		computers = new boolean[N+1];
		
		nodes = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < nodes; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		int start = 1;
		bfs(start);
		
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (computers[i]) count++;
		}
		
		System.out.println(count - 1);
		
	}

	private static void bfs(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		computers[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for (Integer next : adjList[current]) {
				if (!computers[next]) {
					queue.offer(next);
					computers[next] = true;
				}
			}
		}
		
		
	}

}
