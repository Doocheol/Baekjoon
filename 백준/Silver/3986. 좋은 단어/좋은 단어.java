import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Character> stack;
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			
			stack = new ArrayDeque<>();
			String[] line = br.readLine().split("");
			
			for (int j = 0; j < line.length; j++) {
				char ch = line[j].charAt(0);
				if (stack.isEmpty()) {
					stack.push(ch);
				} else if (stack.peek() == ch) {
					stack.pop();
				} else if (stack.peek() != ch) {
					stack.push(ch);
				}
			}
			
			if (stack.isEmpty()) answer++;
		}
		
		System.out.println(answer);
		
	}

}
