import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		
		while (deque.size() >= 2) {
			deque.pollFirst();
			
			if (deque.size() >= 1) {
				deque.offer(deque.pollFirst());
			}
		}
		
		sb.append(deque.peek());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
