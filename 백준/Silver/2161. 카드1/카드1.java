
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		List<Integer> list = new ArrayList<>();
		
		while (!queue.isEmpty()) {
			list.add(queue.poll());
			if (!queue.isEmpty())
			queue.offer(queue.poll());
		}
		
		for (int i : list) {
			sb.append(i).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
