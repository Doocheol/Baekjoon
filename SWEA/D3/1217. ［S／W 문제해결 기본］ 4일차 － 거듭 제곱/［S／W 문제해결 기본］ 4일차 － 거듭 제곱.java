import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = aPowerOf(N, M);
			
			System.out.println("#" + num + " " + result);
		}
		
	} // END main
	
	
	static int aPowerOf(int N, int M) {
		// 기저 조건
		if (M == 0) {
			return 1;
		}
		
		// 재귀 호출
		return N * aPowerOf(N, M-1);
	}
	
}
