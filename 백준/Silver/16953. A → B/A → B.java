import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	
	static int A, B;
	static HashSet<Integer> isVisited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		isVisited = new HashSet<>();
		
		int answer = bfs(A);
		
		System.out.println(answer);
	}

	private static int bfs(int currentValue) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(currentValue);
		isVisited.add(currentValue);
		
		int count = 0;

		while(!queue.isEmpty()) {
			int size = queue.size();
			count++;
			
			
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				
				if (current == B) return count;
				if (current > B) continue;

				int case1 = current * 2;
                long case2Long = (long) current * 10 + 1;  // 큰 수를 처리하기 위해 long 사용
				
                // case1 처리
                if (case1 <= B && !isVisited.contains(case1)) {
                    queue.offer(case1);
                    isVisited.add(case1);
                }

                // case2 처리
                if (case2Long <= B && !isVisited.contains((int) case2Long)) {
                    queue.offer((int) case2Long);
                    isVisited.add((int) case2Long);
                }
				
				
			}
			
			
			
		}
		
		return -1;
	}

}
