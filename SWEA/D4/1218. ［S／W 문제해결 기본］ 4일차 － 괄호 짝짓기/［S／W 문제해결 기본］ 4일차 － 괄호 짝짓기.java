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
		
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int tc = 1; tc<=10; tc++) {
			int CHAR_LENGTH = Integer.parseInt(br.readLine());
			String line = br.readLine();
			
			int answer = 0;
			for (int i = 0; i < CHAR_LENGTH; i++) {
				char ch = line.charAt(i);
				
				if (ch == '(' || ch == '{' || ch == '<' || ch == '[') {
					stack.offerLast(ch);
				} else {
					if (stack.isEmpty()) {
						answer = 0;
						break;
					} else if ((ch == ')' && stack.pollLast() != '(') ||
							(ch=='}' && stack.pollLast() != '{') ||
							(ch =='>' && stack.pollLast() != '<') ||
							(ch == ']' && stack.pollLast() != '[')) {
						answer = 0;
						break;
					} else {
						answer = 1;
					}
					
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
}
