import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine().trim());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		recursive(0);
	}

//	어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.
//	"재귀함수가 뭔가요?"
//	"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//	마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//	그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
//	____"재귀함수가 뭔가요?"
//	____"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
//	____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
//	____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
//	________"재귀함수가 뭔가요?"
//	________"재귀함수는 자기 자신을 호출하는 함수라네"
//	________라고 답변하였지.
//	____라고 답변하였지.
//	라고 답변하였지.
	
	private static void recursive(int repeat) {
		if (repeat == N) {
			for (int i = 0; i < repeat; i++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수가 뭔가요?\"");
			for (int i = 0; i < repeat; i++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for (int i = 0; i < repeat; i++) {
				System.out.print("____");
			}
			System.out.println("라고 답변하였지.");
			return;
		}
		
		for (int i = 0; i < repeat; i++) {
			System.out.print("____");
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		for (int i = 0; i < repeat; i++) {
			System.out.print("____");
		}
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for (int i = 0; i < repeat; i++) {
			System.out.print("____");
		}
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for (int i = 0; i < repeat; i++) {
			System.out.print("____");
		}
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		recursive(repeat+1);
		
		for (int i = 0; i < repeat; i++) {
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");
	}
	

}
