import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A020.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		//테스트케이스 10개
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine().trim());
			String line = br.readLine().trim();
			Stack<Character> stack = new Stack<>();
			
			int answer = 0;
			for (int i = 0; i < line.length(); i++) {
				
				// 여는 괄호를 만나면 스택에 넣는다.
				if (line.charAt(i) == '(' ||
					line.charAt(i) == '{' ||
					line.charAt(i) == '[' ||
					line.charAt(i) == '<') {
					stack.push(line.charAt(i));
				// 닫는 괄호를 만나면
				} else {
					// 스택이 비어 있으면 바로 유효하지 않기 때문에 0을 보관하고 break
					if (stack.isEmpty()) {
						answer = 0;
						break;
						
					}
					// 스택을 pop 했을 때, 쌍을 이루지 못하면 0을 보관하고 break
					if ((line.charAt(i) == ')' && stack.pop() != '(') ||
						(line.charAt(i) == '}' && stack.pop() != '{') ||
						(line.charAt(i) == ']' && stack.pop() != '[') ||
						(line.charAt(i) == '>' && stack.pop() != '<')) {
							answer = 0;
							break;
					} else {
						answer = 1;
					}
					
				}
				
				// 스택이 남아 있으면 불안정한 상태 answer 0
				if (!stack.isEmpty()) {
					answer = 0;
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


