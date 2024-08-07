
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			int pick = Integer.parseInt(st.nextToken());
			list.add(i - pick, i + 1); // 학생 번호는 1부터 시작하므로 i + 1
		}

		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
