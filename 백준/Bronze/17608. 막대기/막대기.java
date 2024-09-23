import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			stack.add(sc.nextInt());
		}
		boolean check = true;
		int count = 1;
		int currentHeight = stack.pollLast();
		while (!stack.isEmpty()) {
			if (stack.peekLast() > currentHeight) {
				currentHeight = stack.peekLast();
				count++;
			}
			stack.pollLast();
			
		}
		
		System.out.println(count);
		
	}

}
