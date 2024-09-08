import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			
			Deque<String> queueA = new ArrayDeque<>();
			Deque<String> queueB = new ArrayDeque<>();
			int WORD_LENGTH = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			
			if (WORD_LENGTH % 2 == 0) {
				for (int i = 0; i < WORD_LENGTH/2; i++) {
					queueA.offer(line[i]);
				}
				for (int i = WORD_LENGTH/2; i < WORD_LENGTH; i++) {
					queueB.offer(line[i]);
				}
			} else {
				for (int i =0; i < (WORD_LENGTH+1)/2; i++) {
					queueA.offer(line[i]);
				}
				for (int i = (WORD_LENGTH+1)/2; i < WORD_LENGTH; i++) {
					queueB.offer(line[i]);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			while(!queueA.isEmpty()) {
				sb.append(queueA.poll()).append(" ");
				
				if (!queueB.isEmpty()) {
					sb.append(queueB.poll()).append(" ");

				}
			}
			sb.append("\n");
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
}
