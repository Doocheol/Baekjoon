
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("src/김두철/A102.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// 스위치 개수
		int N = Integer.parseInt(br.readLine().trim());
		// 스위치 받을 배열
		int[] arr = new int[N];

		// 배열 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 수
		int studentNumber = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < studentNumber; i++) {
			st = new StringTokenizer(br.readLine());

			int sex = Integer.parseInt(st.nextToken());
			int studentIndex = Integer.parseInt(st.nextToken()) - 1;


			// studentIndex-1가 스위치의 인덱스 번호임.
			// 남학생이면
			if (sex == 1) {
				
				// 본인의 배수까지 바꾸기
				for (int j = studentIndex; j < N; j += (studentIndex + 1)) {
					arr[j] = 1 - arr[j];
				}
				
			// 여학생이면	
			} else {
				
				// 기본적으로 어차피 바꿔야 함.
				arr[studentIndex] = 1 - arr[studentIndex];
				
				// 대칭이동해서 바꾸기
				int offset = 1;
				
				// 배열 벗어나는 조건이면 반복문 나오기
				while (studentIndex - offset >= 0 && studentIndex + offset < N) {
					// 대칭이 같으면
					if (arr[studentIndex - offset] == arr[studentIndex + offset]) {
						arr[studentIndex - offset] = 1 - arr[studentIndex - offset];
						arr[studentIndex + offset] = 1 - arr[studentIndex + offset];
						
					// 대칭이 같지 않으면 반복문 나오기
					} else {
						break;
					}
					
					//다음 대칭 확인하기
					offset++;
				}
				
			}

				

		}

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
            if ((i + 1) % 20 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }


		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}
