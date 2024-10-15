import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] isVisited;
	static int[] parent;

    
    // 주석 부분은 처음에 유니온 파인드로 시작했던..
//	static int[] parent;

    
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from].add(to);
			adjList[to].add(from);
		}

		DFS(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

//		N = Integer.parseInt(br.readLine());
//		
//		parent = new int[N+1];
//		
//		for (int i = 0; i <= N; i++) {
//			parent[i] = i;
//		}
//		
//		for (int i = 0; i < N-1; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			union(a, b);
//		}
//		
//		for (int i = 2; i <= N; i++) {
//			sb.append(find(i)).append("\n");
//		}
//		bw.write(sb.toString());
//		bw.flush();
//		bw.close();
//		br.close();
//		
//		
//	}
//
//	private static void union(int a, int b) {
//		a = find(a);
//		b = find(b);
//		
//		if (a != b) parent[b] = a;
//	}
//
//	private static int find(int x) {
//		if (x == parent[x]) return x; 
//		else return parent[x] = find(parent[x]);
//	}

	}

	private static void DFS(int currentNode) {
		isVisited[currentNode] = true;
		
		for (int next : adjList[currentNode]) {
			if (!isVisited[next]) {
				parent[next] = currentNode;
				DFS(next);
			}
		}
		
		
	}
}
