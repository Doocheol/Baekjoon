import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;

public class Solution {
	
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A준비/SWEA_5658_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			K = Integer.parseInt(line[1]);
			
			String hex = br.readLine();
			Deque<Character> queue = new ArrayDeque<>();
			HashSet<Integer> set = new HashSet<>(); // 중복 제거를 위해 HashSet 사용
			
			for (int i = 0; i < N; i++) {
				queue.offer(hex.charAt(i));
			}
			
			for (int i = 0; i < N / 4; i++) { // 각 회전마다 숫자 추출
				for (int j = 0; j < 4; j++) {
					String hexAnswer = "";
					for (int k = 0; k < N / 4; k++) {
						hexAnswer += queue.peek();
						queue.offer(queue.poll()); // 앞에서 빼서 뒤로 넣기
					}
					set.add(Integer.parseInt(hexAnswer, 16)); // 16진수 변환
				}
				queue.offerFirst(queue.pollLast()); // 시계 방향으로 회전
			}
			
			ArrayList<Integer> list = new ArrayList<>(set); // set을 list로 변환
			Collections.sort(list, Collections.reverseOrder()); // 큰 수부터 정렬.
			
			sb.append("#").append(tc).append(" ").append(list.get(K - 1)).append("\n"); // K번째 값 출력
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
